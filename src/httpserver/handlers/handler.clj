(ns httpserver.handlers.handler)

(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))
(import '(com.td.HttpServer HttpRequest))

(deftype handler []
  com.td.HttpServer.IHandler
  (generateResponse [this httpRequest]
  (let [request {:code (.responseCode httpRequest) :headers (.headers httpRequest) :body (.body httpRequest)}]
    (println (request))
    )
  (doto (HttpResponse.)
    (.setBody "I'm a teapot", "text/plain")
    (.setResponseCode 418))))

