(ns httpserver.handlers.teapot)

(defn call [request]
  (hash-map :code 418 :headers (hash-map "Content-Type" "text/plain") :body "I'm a teapot!"))
