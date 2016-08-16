(ns httpserver.teapot-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.teapot :as teapot]))

(describe "teapotHandler"
  (it "returns a map with :code 418"
     (should= 418 (:code (teapot/call :dummy-request :dummy-working-directory))))
  (it "returns a map with :body I'm a teapot!"
     (should= "I'm a teapot!" (:body (teapot/call :dummy-request :dummy-working-directory))))
  (it "returns a map with :headers {Content-Type text/plain}"
      (should= {"Content-Type" "text/plain"} (:headers (teapot/call :dummy-request :dummy-working-directory)))))
