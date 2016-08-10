(ns httpserver.ok-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.ok :as ok]))

(describe "ok"
  (it "returns a map with :code 200"
    (should= 200 (:code (ok/call :dummy-request :dummy-working-directory))))
  (it "returns a mape with :body OK"
    (should= "OK" (:body (ok/call :dummy-request :dummy-working-directory))))
  (it "returns a map that has a :header with map of Content-Type text/plain"
    (should= {"Content-Type" "text/plain"} (:headers (ok/call :dummy-request :dummy-working-directory)))))
