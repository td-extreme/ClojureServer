(ns httpserver.options_spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.options :as options]))

(describe "options"
  (it "returns a map with :body ''"
    (should= "" (:body (options/call :dummy-request :dummy-dir))))
  (it "returns a map with :code 200"
    (should= 200 (:code (options/call :dummy-request :dummy-dir))))
  (it "returns a map with :header with a map of 'Allow' 'GET,HEAD,POST,OPTIONS,PUT'"
    (should= {"Allow" "GET,HEAD,POST,OPTIONS,PUT"} (:headers (options/call :dummy-request :dummy-dir)))))
