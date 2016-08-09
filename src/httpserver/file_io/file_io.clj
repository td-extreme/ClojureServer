(ns httpserver.file-io.file-io
  (:require [clojure.java.io :as io])
  (:import java.io.FileInputStream))

(defn partial-content [array-of-bytes start end]
  (subvec (mapv byte array-of-bytes) start end))

(defn get-file-contents-as-bytes [path]
  (let [file (io/file path)
        byte-array-of-file (byte-array (.length file))
        input-stream (FileInputStream. file)]
    (.read input-stream byte-array-of-file)
    (.close input-stream)
    byte-array-of-file))
