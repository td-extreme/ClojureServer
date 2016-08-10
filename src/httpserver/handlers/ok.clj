(ns httpserver.handlers.ok)

(defn call [request working-directory]
  {:code 200 :headers {"Content-Type" "text/plain"} :body "OK"})
