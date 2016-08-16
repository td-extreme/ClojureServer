(ns httpserver.handlers.head
  (:require [httpserver.handlers.two-hundred :as two-hundred]
            [httpserver.handlers.four-zero-four :as four-zero-four]))

(defn call [request]
  (cond
    (= "/" (:path request)) (two-hundred/call request)
    (= "/foobar" (:path request)) (four-zero-four/call request)))

