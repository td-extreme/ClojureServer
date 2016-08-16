(ns httpserver.routing.routes
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.two-hundred :as two-hundred]
            [httpserver.handlers.parameter-decode :as parameter-decode]
            [httpserver.handlers.head :as head]
            [httpserver.handlers.redirect :as redirect]))

(def list-of-routes (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/tea" :handler two-hundred/call}
                          {:method "GET" :path "/parameters" :handler parameter-decode/call}
                          {:method "HEAD" :path "*" :handler head/call}
                          {:method "GET" :path "/redirect" :handler redirect/call}))
