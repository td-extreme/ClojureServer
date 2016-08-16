(ns httpserver.redirect-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.redirect :as redirect]))

(describe "redirect handler"
  (let [request {:method "GET"
                 :path "/redirect"
                 :headers {"Host" "localhost:5000"}}]
    (it "returns a map with :code 302"
      (should= 302 (:code (redirect/call request :dummy-dir))))
    (it "returns a map with :headers {'Location' 'http://localhost:5000/' if request has header 'Host' 'localhost:5000'"
      (should= {"Location" "http://localhost:5000/"} (:headers (redirect/call request :dummy-dir))))
    (it "returns a mapt with :headers {'Location' '/' if no 'Host' header in request"
      (should= {"Location" "/"} (:headers (redirect/call {:method "GET" :path "/redirect" :headers {}} :dummy-dir))))
    (it "returns an emtpy body"
      (should= "" (:body (redirect/call request :dummy-dir))))))
