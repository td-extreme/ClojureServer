(ns httpserver.file-io-spec
 (:require [speclj.core :refer :all]
           [httpserver.file-io.file-io :as file-io]))

(describe "file io"
  (describe "partial content"
    (it "returns a subvector of [3 4 5] for arguemnts [1, 2, 3, 4, 5, 6, 7] 2 4"
      (let [myArray [1, 2, 3, 4, 5, 6, 7]]
        (should= [3 4 5] (file-io/partial-content myArray 2 5))))))
