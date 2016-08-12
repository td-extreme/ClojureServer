(ns httpserver.handlers.get-form
  (:require [httpserver.file-io.file-input :as file-input]
            [httpserver.file-io.file-type-checker :as file-type-checker]))

(defn get-form-contents [working-directory]
  (cond
    (= true (file-type-checker/is-file  working-directory "/form")) (apply str (map char (file-input/get-file-contents-as-bytes (str working-directory "/form"))))
    :else ""))

(defn call [request working-directory]
  {:code 200 :headers {} :body (get-form-contents working-directory)})
