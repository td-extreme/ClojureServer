(ns httpserver.routing.routes
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.two-hundred :as two-hundred]
            [httpserver.handlers.parameter-decode :as parameter-decode]
            [httpserver.handlers.head :as head]
            [httpserver.handlers.redirect :as redirect]
            [httpserver.handlers.options :as options]
            [httpserver.handlers.options_two :as options-two]
            [httpserver.handlers.partial-content :as partial-content]
            [httpserver.handlers.get-form :as get-form]
            [httpserver.handlers.delete-form :as delete-form]
            ))

(def list-of-routes (list {:method "GET" :path "/coffee" :handler teapot/call}
                          {:method "GET" :path "/tea" :handler two-hundred/call}
                          {:method "GET" :path "/partial_content.txt" :handler partial-content/call}
                          {:method "GET" :path "/parameters" :handler parameter-decode/call}
                          {:method "HEAD" :path "*" :handler head/call}
                          {:method "OPTIONS" :path "/method_options" :handler options/call}
                          {:method "OPTIONS" :path "/method_options2" :handler options-two/call}
                          {:method "GET" :path "/redirect" :handler redirect/call}
                          {:method "GET" :path "/form" :handler get-form/call}
                          {:method "DELETE" :path "/form" :handler delete-form/call}
                          ))
