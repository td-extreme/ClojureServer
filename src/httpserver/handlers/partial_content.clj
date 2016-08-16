(ns httpserver.handlers.partial-content
  (:require [clojure.string :as string]
            [httpserver.file-io.file-input :as file-input]))

(defn- get-range-array [raw-range-header]
  (string/split (nth (string/split raw-range-header #"=") 1) #""))

(defn- get-file-contents [working-dir path]
  (file-input/get-file-contents-as-bytes working-dir path))

(defn- range-minus-end [value byte-count]
  [(- byte-count value) byte-count])

(defn- to-long [range-array index]
  (new Long (nth range-array index)))

(defn- get-range [raw-range-header byte-count]
  (let [range-array (get-range-array raw-range-header)]
    (cond
      (= 3 (count range-array)) [(to-long range-array 0) (+ 1 (to-long range-array 2))]
      (= "-" (nth range-array 0)) (range-minus-end (to-long range-array 1) byte-count)
      (= "-" (nth range-array 1)) [(to-long range-array 0) byte-count])))

(defn- bytes-partial-content [array-of-bytes start end]
  (subvec (mapv byte array-of-bytes) start end))

(defn- get-body [request working-dir]
  (let [path (:path request)
        file-bytes (get-file-contents working-dir path)
        byte-count (count file-bytes)
        raw-range-header (get (:headers request) "Range")
        file-range (get-range raw-range-header byte-count)
        body (bytes-partial-content file-bytes (nth file-range 0) (nth file-range 1))]
        (apply str (map char body))))

(defn call [request working-dir]
  {:code 206 :headers {"Content-Type" "text/plain"} :body (get-body request working-dir)})
