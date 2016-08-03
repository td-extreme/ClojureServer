(ns httpserver.ok-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.ok :as ok]))

(describe "ok"
  (it "the map returned has key :code value of 200"
     (should= 200 (:code (ok/call "dummy"))))
  (it "the map returned has key :body value of OK"
     (should= "OK" (:body (ok/call "dummy"))))
  (it "the map returned has a :header map with key Content-Type value of text/plain"
      (should= (hash-map "Content-Type" "text/plain") (:headers (ok/call "dummy")))))
