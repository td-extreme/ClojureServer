(ns httpserver.handler_spec
   (:require [speclj.core :refer :all]
   [httpserver.handlers.handler :as handler]
   [httpserver.handlers.teapot :as teapot]
   [httpserver.routing.router :as router]
   ))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer HttpRequest))

(describe "generating a response"
  (it "returns a HttpResponse with code 418 when passed a HttpRequest GET /coffee"
      (let [test-list [{:method "GET" :path "/coffee" :handler teapot/call}]
            httpRequest (HttpRequest. "GET /coffee HTTP/1.1" (java.util.HashMap. {"this" "that"}))
            main-handler (handler/new-handler test-list)
            httpResponse (.generateResponse main-handler httpRequest)]
      (should= 418 (.responseCode httpResponse)))))
