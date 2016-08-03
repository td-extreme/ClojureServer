(ns httpserver.handler_function_selector_spec
   (:require [speclj.core :refer :all]
   [httpserver.handlers.handler :as handler]))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer HttpRequest))

(describe "main handler"
  (it "returns a HttpResponse with code 418 when given an HttpRequest GET /coffee"
    (let [httpRequest (HttpRequest. "GET /coffee HTTP/1.1" (java.util.HashMap. {"this" "that"}))
          main-handler (handler/new-handler)
          httpResponse (.generateResponse main-handler httpRequest)]
      (should= 418 (.responseCode httpResponse)))))
