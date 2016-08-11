(ns httpserver.file-io-spec
 (:require [speclj.core :refer :all]
           [httpserver.file-io.file-input :as file-input]))

(describe "file io"
  (describe "reading a file"
    (it "returns contents of testfile as byte-array"
        (should= (type (byte-array 3)) (type (file-input/get-file-contents-as-bytes
                              "./folder_for_io_testing"
                              "/test.txt"))))
   (it "returns a byte-array of length 33 when asked to open test.txt file"
     (should= 33 (count (file-input/get-file-contents-as-bytes
                            "./folder_for_io_testing"
                            "/test.txt")))))

  (describe "partial content"
    (it "return a byte-array of the sting 'file' for range 8 12"
      (should= "file" (apply str (map char (file-input/get-file-partial-content
                                              "./folder_for_io_testing"
                                              "/test.txt"
                                              8 12)))))))
