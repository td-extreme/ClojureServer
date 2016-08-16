(ns httpserver.head_spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.head :as head]))

(describe "head method handler"
  (it "returns a map with :code 200 for valid path '/'"
    (should= 200 (:code (head/call {:method "HEAD" :path "/"}))))
  (it "returns a map with :code 404 for invalid path '/foobar'"
    (should= 404 (:code (head/call {:method "HEAD" :path "/foobar"})))))
