(ns httpserver.partial-content-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.partial-content :as partial-content]))

(describe "partial content"
  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=0-4"
      (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=0-4"}}
            working-dir "./folder_for_io_testing"
            response (partial-content/call request working-dir)]
      (should= "This" (apply str (map char (:body response))))))
  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=0-4"
      (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=-6"}}
            working-dir "./folder_for_io_testing"
            response (partial-content/call request working-dir)]
      (should= "e io\n" (apply str (map char (:body response))))))
  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=4-"
      (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=4-"}}
            working-dir "./folder_for_io_testing"
            response (partial-content/call request working-dir)]
      (should= " is a file for testing the io\n" (apply str (map char (:body response))))))
  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=-6"
      (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=-6"}}
            working-dir "./folder_for_io_testing"
            response (partial-content/call request working-dir)]
      (should= 200 (:code response)))))

(describe "helper functions"
  (it "returns ['0' '-' '4'] for 'bytes=0-4'"
      (should= ["0" "-" "4"] (partial-content/get-range-array "bytes=0-4"))))

(describe "get-file"
  (it "returns contents of test.txt"
      (should= "This is a file for testing the io\n"
               (apply str (map char (partial-content/get-file-contents
                                      "./folder_for_io_testing"
                                      "/test.txt"))))))

(describe "get-file-count"
  (it "returns 34"
    (should= 34 (count (partial-content/get-file-contents
                         "./folder_for_io_testing"
                         "/test.txt")))))

(describe "get-body"
  (it "return 'This' for range of 0 4"
    (should= "This" (apply str (map char (partial-content/get-body
                      {:path "/test.txt"
                       :headers {"Range" "bytes=0-4"}}
                      "./folder_for_io_testing"))))))

(describe "get range as int"
  (it "returns [0 4]"
      (should= [0 4] (partial-content/get-range "bytes=0-4" 76)))

  (it "returns [71 76]"
      (should= [71 76] (partial-content/get-range "bytes=-6" 76)))

  (it "returns [4 76]"
      (should= [4 76] (partial-content/get-range "bytes=4-" 76))))
