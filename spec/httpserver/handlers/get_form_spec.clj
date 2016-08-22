(ns httpserver.get-form-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.get-form :as get-form]
            [httpserver.file-io.file-input :as file-input]
            [httpserver.file-io.file-type-checker :as file-type-checker]
))

(import '(java.io File))

(describe "Getting a form"
  (context "No form has been posted"
     (it "returns a map with :code 200"
        (should= 200 (:code (get-form/call :dummy-request "."))))

      (it "returns a map with :body ''"
        (should= "" (:body (get-form/call :dummy-request "."))))))


