(ns httpserver.handlers.ok)

(defn call [request]
  (hash-map :code 200 :headers (hash-map "Content-Type" "text/plain") :body "OK"))
