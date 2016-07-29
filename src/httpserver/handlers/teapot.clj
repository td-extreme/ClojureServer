(ns httpserver.handlers.teapot)

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(deftype teapotHandler []
  com.td.HttpServer.IHandler
  (generateResponse [this]
    (let [response (HttpResponse.)]
    (.setBody response "I'm a teapot", "text/plain")
    (.setResponseCode response 418)
    response)))

(defn new-teapotHandler []
  (teapotHandler.))
