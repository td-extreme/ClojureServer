(ns httpserver.file-io-spec
 (:require [speclj.core :refer :all]
           [httpserver.file-io.file-input :as file-input]))

(describe "file io"
  (describe "reading a file"
    (it "returns contents of testfile as byte-array"
        (should= (type (byte-array 3)) (type (file-input/get-file-contents-as-bytes
                              "./folder_for_io_testing"
                              "/test.txt"))))
   (it "returns a byte-array of length 34 when asked to open test.txt file"
     (should= 34 (count (file-input/get-file-contents-as-bytes
                            "./folder_for_io_testing"
                            "/test.txt"))))))

