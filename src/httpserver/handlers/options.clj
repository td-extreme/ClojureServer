(ns httpserver.handlers.options)

(defn call [request]
  {:code 200 :headers {"Allow" "GET,HEAD,POST,OPTIONS,PUT"} :body ""})
