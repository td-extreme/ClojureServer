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
      (let [test-list (list {:method "GET" :path "/coffee" :handler teapot/call}
                            {:method "GET" :path "/test"}
                            {:method "PUT" :path "/test"})
            httpRequest (HttpRequest. "GET /coffee HTTP/1.1" (java.util.HashMap. {"this" "that"}))
            main-handler (handler/new-handler test-list)
            httpResponse (.generateResponse main-handler httpRequest)]
      (should= 418 (.responseCode httpResponse)))))

(describe "adding routes"
  (it "properly saves the list of routes passed in when new handler is called"
    (let [test-list (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/test"}
                          {:method "PUT" :path "/test"})
          main-handler (handler/new-handler test-list)]
      (should= test-list handler/routes ))))
