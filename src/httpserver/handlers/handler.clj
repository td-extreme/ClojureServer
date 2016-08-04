(ns httpserver.handlers.handler
  (:require [httpserver.router :as router]))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(defn build-request [httpRequest]
  (hash-map :path (.path httpRequest) :method (.method httpRequest) :headers (.headers httpRequest) :body (.body httpRequest)))

(deftype main-handler []
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]
    (let [request (build-request httpRequest)
          function-to-use (router/get-function request)
          response (function-to-use request)
          headers (java.util.HashMap. (:headers response))]
      (doto (HttpResponse.)
        (.setBody (:body response))
        (.setResponseCode (:code response))
        (.addHeaders headers)))))

(defn new-handler []
  (main-handler.))
