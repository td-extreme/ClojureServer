(ns httpserver.two-hundred-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.two-hundred :as two-hundred]))

(describe "two hundred handler"
  (it "returns a map with :code 200"
    (should= 200 (:code (two-hundred/call :dummy-request :dummy-dir)))) (it "returns a mape with :body OK"
    (should= "" (:body (two-hundred/call :dummy-request :dummy-dir))))
  (it "returns a map that has a :header with map of Content-Type text/plain"
    (should= {} (:headers (two-hundred/call :dummy-request :dummy-dir)))))
