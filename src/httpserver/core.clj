(ns httpserver.core
  (:require [httpserver.handlers.handler :as handler]
            [httpserver.utilities.arguments :as arguments]
            [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]
            )
  (:gen-class))

(import '(com.td.HttpServer HttpServer))
(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(defn -main [& args]
  (let [{:keys [options]} (arguments/build-map args)]
    (let [server (HttpServer. (:port options) (:directory options))
          routes (list * {:method "GET" :path "/coffee" :handler teapot/call}
          {:method "GET" :path "/tea" :handler ok/call})
          main-handler (handler/new-handler routes)]
      (.addRoute server "GET" "/coffee" main-handler)
      (.addRoute server "GET" "/tea" main-handler)
      (.run server))))
