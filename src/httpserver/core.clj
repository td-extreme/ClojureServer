(ns httpserver.core
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]
            [httpserver.utilities.arguments :as arguments])
  (:gen-class))

(import '(com.td.HttpServer HttpServer))
(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(defn -main [& args]
  (let [{:keys [options]} (arguments/build-map args)]
    (let [server (HttpServer. (:port options) (:directory options))
          teapot-handler (teapot/new-teapot-handler)
          ok-handler (ok/new-ok-handler)
          ]

      (.addRoute server "GET" "/coffee" teapot-handler)
      (.addRoute server "GET" "/tea" ok-handler)
      (.run server))))
