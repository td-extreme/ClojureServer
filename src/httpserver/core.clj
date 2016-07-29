(ns httpserver.core
  (:require [httpserver.handlers.teapot :as myteapot]
            [httpserver.utilities.arguments :as argumenetParser]))

(import '(com.td.HttpServer HttpServer))
(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))


(defn -main [& args]
  (let [{:keys [options]} (argumenetParser/buildMap args)]
    (let [server (HttpServer. (:port options) (:directory options))
          myTea (myteapot/new-teapotHandler)]
      (.addRoute server "GET" "/teapot" myTea)
      (.run server))))
