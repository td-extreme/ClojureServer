(ns httpserver.handlers.parameter-decode
  (:require [clojure.string :as string])
  (:import java.net.URLDecoder))

(defn- decode-url [parameters]
  (URLDecoder/decode parameters))

(defn- build-body [parameters]
  (decode-url (string/replace parameters #"&" "\n")))

(defn call [request working-directory]
  {:code 200 :headers {"Content-Type" "text/plain"} :body (build-body (:parameters request))})
