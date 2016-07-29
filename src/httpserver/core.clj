(ns httpserver.core
  (:require [httpserver.handlers.teapot :as myteapot]
            [httpserver.utilities.arguments :as argumenetParser])
  (:gen-class))

(import '(com.td.HttpServer HttpServer))
(import '(com.td.HttpServer HttpResponse))
(import '(com.td.HttpServer IHandler))

(def display_welcome "Http Server!")

(defn -main [& args]
  (println display_welcome)
  (let [{:keys [options]} (argumenetParser/buildMap args)]
    (let [server (HttpServer. (:port options) (:directory options))
          myTea (myteapot/new-teapotHandler)]
      (.addRoute server "GET" "/teapot" myTea)
      (.run server))))
