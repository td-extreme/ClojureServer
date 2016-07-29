(ns httpserver.teapot-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.teapot :as teapot]))

(import '(com.td.HttpServer HttpResponse))

(describe "teapotHandler"
  (it "returns an HttpRequest with code 418"
    (let [testTeapot (teapot/new-teapot-handler)
          response (.generateResponse testTeapot)]
      (should= 418 (.responseCode response)))))
