(ns httpserver.routing.routes
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]
            [httpserver.handlers.parameter-decode :as parameter-decode]
            ))

(def list-of-routes (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/tea" :handler ok/call}
                          {:method "GET" :path "/parameters" :handler parameter-decode/call}))
