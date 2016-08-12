(ns httpserver.file-io.file-type-checker
  (:require [clojure.java.io :as io]))

(defn file-exists [working-directory path]
  (.exists (io/as-file (str working-directory path))))

(defn is-dir [working-directory path]
  (.isDirectory (io/as-file (str working-directory path))))

(defn is-file [working-directory path]
  (.isFile (io/as-file (str working-directory path))))
