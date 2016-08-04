(ns httpserver.handlers.teapot)

(defn call [request]
  {:code 418 :headers {"Content-Type" "text/plain"} :body "I'm a teapot!"})
