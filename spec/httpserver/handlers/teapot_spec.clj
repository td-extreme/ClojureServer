(ns httpserver.teapot-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.teapot :as teapot]))

(describe "teapotHandler"
  (it "the map returned has key :code value of 418"
     (should= 418 (:code (teapot/call "dummy"))))
  (it "the map returned has key :body value of I'm a teapot!"
     (should= "I'm a teapot!" (:body (teapot/call "dummy"))))
  (it "the map returned has a :header map with key :Content-Type value of text/plain"
     (should= "text/plain" (:Content-Type (:headers (teapot/call "dummy")))))
  )
