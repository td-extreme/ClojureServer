(ns httpserver.head_spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.head :as head]))

(describe "head method handler"
  (it "returns a map with :code 200 for valid path '/'"
    (should= 200 (:code (head/call {:method "HEAD" :path "/"} :dummy-dir))))
  (it "returns a map with :code 404 for invalid path '/foobar'"
    (should= 404 (:code (head/call {:method "HEAD" :path "/foobar"} :dummy-dir))))
  (it "returns a map with :code 200 for /method_options"
    (should= 200 (:code (head/call {:method "HEAD" :path "/method_options"} :dummy-dir))))
  (it "returns a map with :code 200 for /method_options2"
    (should= 200 (:code (head/call {:method "HEAD" :path "/method_options2"} :dummy-dir)))))
