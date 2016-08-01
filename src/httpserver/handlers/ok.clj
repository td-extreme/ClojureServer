(ns httpserver.handlers.ok)

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(deftype ok-handler []
  com.td.HttpServer.IHandler
  (generateResponse [this]
    (HttpResponse.)))

(defn new-ok-handler []
  (ok-handler.))
