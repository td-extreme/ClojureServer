(ns httpserver.handlers.ok)

(defn call [request]
  {:code 200 :headers {"Content-Type" "text/plain"} :body "OK"})
