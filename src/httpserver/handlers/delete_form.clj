(ns httpserver.handlers.delete-form
  (:require [clojure.java.io :as io]))

(defn delete [working-directory path]
  (println (str working-directory path))
  (io/delete-file (str working-directory path)))

(defn call [request working-directory]
  (delete working-directory (:path request))
  {:code 200 :headers {} :body ""})

