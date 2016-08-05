(ns httpserver.routing.router)

(defn- check-route [method path route]
  (and (= (:method route) method) (= (:path route) path)))

(defn- find-route [method path routes]
  (some #(when (check-route method path %) %) routes))

(defn get-handler [{:keys [method path]} routes]
  (:handler (find-route method path routes)))

(defn add-routes [server list-of-routes main-handler]
  (run! #(.addRoute server (:method %) (:path %) main-handler) list-of-routes))
