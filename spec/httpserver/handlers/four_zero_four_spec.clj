(ns httpserver.four-zero-four-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.four-zero-four :as four-zero-four]))

(describe "Four Zero Four Handler"
  (it "returns a map with :code 404"
    (should= 404 (:code (four-zero-four/call :dummy-request))))
  (it "returns a map with :headers {}"
    (should= {} (:headers (four-zero-four/call :dummy-request))))
  (it "returns a map with :body ''"
    (should= "" (:body (four-zero-four/call :dummy-request)))))
