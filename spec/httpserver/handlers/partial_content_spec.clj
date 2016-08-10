(ns httpserver.partial-content-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.partial-content :as partial-content]))

(describe "partial content"
  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=0-4"
    (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=0-4"}}
          working-dir "./folder_for_io_testing"
          response (partial-content/call request working-dir)]
      (should= "This " (:body response))))

  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=0-4"
    (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=-6"}}
          working-dir "./folder_for_io_testing"
          response (partial-content/call request working-dir)]
      (should= "he io\n" (:body response))))

  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=4-"
    (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=4-"}}
          working-dir "./folder_for_io_testing"
          response (partial-content/call request working-dir)]
      (should= " is a file for testing the io\n" (:body response))))

  (it "returns map with :body byte-array of the string 'This' when header contains Range: byte=-6"
    (let [request {:method "GET" :path "/test.txt" :headers {"Range" "bytes=-6"}}
          working-dir "./folder_for_io_testing"
          response (partial-content/call request working-dir)]
      (should= 206 (:code response)))))
