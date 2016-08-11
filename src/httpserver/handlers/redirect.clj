(ns httpserver.handlers.redirect)

(defn call [request]
  (cond
    (= nil (get (:headers request) "Host")) {:code 302 :headers {"Location" "/" } :body ""}
    :else   {:code 302 :headers {"Location" (str "http://" (get (:headers request) "Host") "/")} :body ""}))
