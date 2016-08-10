(ns httpserver.routing.routes
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.two_hundred :as two_hundred]
            [httpserver.handlers.parameter-decode :as parameter-decode]
            [httpserver.handlers.head :as head]
            ))

(def list-of-routes (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/tea" :handler two_hundred/call}
                          {:method "GET" :path "/parameters" :handler parameter-decode/call}
                          {:method "HEAD" :path "*" :handler head/call}))
