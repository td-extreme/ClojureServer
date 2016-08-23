(ns httpserver.handlers.head
  (:require [httpserver.handlers.two-hundred :as two-hundred]
            [httpserver.handlers.four-zero-four :as four-zero-four]))

(defn call [request working-directory]
  (cond
    (= "/" (:path request)) (two-hundred/call request working-directory)
    (= "/foobar" (:path request)) (four-zero-four/call request working-directory)
    :else (two-hundred/call request working-directory)))
