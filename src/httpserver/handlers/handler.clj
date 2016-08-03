(ns httpserver.handlers.handler
  (:require [httpserver.handlers.handler_function_selector :as selector]))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(deftype main-handler []
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]
    (let [request (hash-map :path (.path httpRequest) :method (.method httpRequest) :headers (.headers httpRequest) :body (.body httpRequest))
          function-to-use (selector/get-function request)
          response (function-to-use request)
          headers (java.util.HashMap. (:headers response))
          ]
      (doto (HttpResponse.)
        (.setBody (:body response))
        (.setResponseCode (:code response))
        (.addHeaders headers)))))

(defn new-handler []
  (main-handler.))
