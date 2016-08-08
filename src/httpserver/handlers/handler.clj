(ns httpserver.handlers.handler
  (:require [httpserver.routing.router :as router]))

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(defn build-request [httpRequest]
  {:path (.path httpRequest)
   :method (.method httpRequest)
   :headers (.headers httpRequest)
   :parameters (.parameters httpRequest)
   :body (.body httpRequest)})

(defrecord MainHandler [list-of-routes]
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]
    (let [request (build-request httpRequest)
          function-to-use (router/get-handler request list-of-routes)
          response (function-to-use request)
          headers (java.util.HashMap. (:headers response))]
      (doto (HttpResponse.)
        (.setBody (:body response))
        (.setResponseCode (:code response))
        (.addHeaders headers)))))

(defn new-handler [list-of-routes]
  (MainHandler. list-of-routes))
