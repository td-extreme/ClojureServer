(ns httpserver.handlers.parameter-decode)

(defn decode [parameters]
  (java.net.URLDecoder/decode parameters))

(defn build-body [parameters]
  (decode (clojure.string/replace parameters #"&" "\n"))
  )

(defn call [request]
  {:code 200 :headers {"Content-Type" "text/plain"} :body (build-body (:parameters request))}
  )
