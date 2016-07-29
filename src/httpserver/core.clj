(ns httpserver.core
  (:require [httpserver.handlers.teapot :as teapot]
            [httpserver.utilities.arguments :as arguments])
  (:gen-class))

(import '(com.td.HttpServer HttpServer))
(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(defn -main [& args]
  (let [{:keys [options]} (arguments/build-map args)]
    (let [server (HttpServer. (:port options) (:directory options))
          teapot-handler (teapot/new-teapot-handler)]
      (.addRoute server "GET" "/teapot" teapot-handler)
      (.run server))))
