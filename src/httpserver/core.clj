(ns httpserver.core
  (:require [httpserver.handlers.handler :as handler]
            [httpserver.utilities.arguments :as arguments]
            [httpserver.routing.router :as router]
            [httpserver.routes.routes :as routes])
  (:gen-class))

(import '(com.td.HttpServer HttpServer))

(defn -main [& args]
  (let [{:keys [options]} (arguments/build-map args)]
    (let [server (HttpServer. (:port options) (:directory options))
          main-handler (handler/new-handler routes/list-of-routes)]
      (router/add-routes server routes/list-of-routes main-handler)
      (.run server))))
