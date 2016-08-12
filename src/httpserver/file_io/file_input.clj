(ns httpserver.file-io.file-input
  (:require [clojure.java.io :as io])
  (:import java.io.FileInputStream))

(defn- partial-content [array-of-bytes start end]
  (subvec (mapv byte array-of-bytes) start end))

(defn get-file-contents-as-bytes [working-directory path]
  (let [file (io/file (str working-directory path))
        byte-array-of-file (byte-array (.length file))
        input-stream (FileInputStream. file)]
    (.read input-stream byte-array-of-file)
    (.close input-stream)
    byte-array-of-file))

(defn get-file-partial-content [working-directory path start end]
  (partial-content (get-file-contents-as-bytes working-directory path) start end))
