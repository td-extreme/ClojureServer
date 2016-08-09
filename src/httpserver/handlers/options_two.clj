(ns httpserver.handlers.options_two)

(defn call [request]
  {:code 200 :headers {"Allow" "GET,OPTIONS"} :body ""})
