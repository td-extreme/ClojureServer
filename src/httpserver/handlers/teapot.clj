(ns httpserver.handlers.teapot)

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(deftype teapotHandler []
  com.td.HttpServer.IHandler
  (generateResponse [this]
  (doto (HttpResponse.)
    (.setBody "I'm a teapot", "text/plain")
    (.setResponseCode 418))))

(defn new-teapotHandler []
  (teapotHandler.))
