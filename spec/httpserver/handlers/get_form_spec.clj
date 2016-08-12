(ns httpserver.get-form-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.get-form :as get-form]))

(import '(java.io File))

(describe "No form has been posted"
  (it "returns a map with :code 200"
    (should= 200 (:code (get-form/call :dummy-request "."))))

  (it "returns a map with :body ''"
    (should= "" (:body (get-form/call :dummy-request "."))))

   (it "returns a map with :code 200"
    (should= "this" (:body (get-form/call :dummy-request "."))))


