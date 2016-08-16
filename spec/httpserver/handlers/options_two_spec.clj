(ns httpserver.options_two_spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.options_two :as options_two]))

(describe "options_two"
  (it "returns a map with :body ''"
    (should= "" (:body (options_two/call :dummy-request))))
  (it "returns a map with :code 200"
    (should= 200 (:code (options_two/call :dummy-request))))
  (it "returns a map with :header with a map of 'Allow' 'GET,OPTIONS"
    (should= {"Allow" "GET,OPTIONS"} (:headers (options_two/call :dummy-request)))))
