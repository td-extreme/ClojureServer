(ns httpserver.handlers.handler
  (:require [httpserver.handlers.ok :as ok])
  )

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(deftype main-handler []
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]

))
(defn new-handler []
  (main-handler.))
