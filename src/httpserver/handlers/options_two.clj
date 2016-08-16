(ns httpserver.handlers.options_two)

(defn call [request working-directory]
  {:code 200 :headers {"Allow" "GET,OPTIONS"} :body ""})
