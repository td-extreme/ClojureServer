(ns httpserver.handlers.redirect)

(defn call [request]
  {:code 302 :headers {"Location" (str "http://" (get (:headers request) "Host") "/")} :body ""})
