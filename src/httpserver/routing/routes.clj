(ns httpserver.routing.routes
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]
            [httpserver.handlers.parameter-decode :as parameter-decode]
            [httpserver.handlers.options :as options]
            [httpserver.handlers.options_two :as options_two]
            ))

(def list-of-routes (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/tea" :handler ok/call}
                          {:method "GET" :path "/parameters" :handler parameter-decode/call}
                          {:method "OPTIONS" :path "/method_options" :handler options/call}
                          {:method "OPTIONS" :path "/method_options2" :handler options_two/call}))
