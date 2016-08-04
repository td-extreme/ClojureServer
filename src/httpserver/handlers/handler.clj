(ns httpserver.handlers.handler
  (:require [httpserver.routing.router :as router]))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(defn build-request [httpRequest]
  (hash-map :path (.path httpRequest) :method (.method httpRequest) :headers (.headers httpRequest) :body (.body httpRequest)))

(def routes {})

(deftype main-handler []
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]
    (let [request (build-request httpRequest)
          function-to-use (router/get-handler request routes)
          response (function-to-use request)
          headers (java.util.HashMap. (:headers response))]
      (doto (HttpResponse.)
        (.setBody (:body response))
        (.setResponseCode (:code response))
        (.addHeaders headers)))))

(defn new-handler [list-of-routes]
  (def routes list-of-routes)
  (main-handler.))
