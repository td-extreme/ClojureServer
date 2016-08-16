(ns httpserver.routing.router)

(defn- check-method [path1 path2]
  (cond
    (= path1 "*") true
    (= path1 path2) true
    :else false))

(defn- check-route [method path route]
  (and (= (:method route) method) (check-method (:path route) path)))

(defn- find-route [method path routes]
  (some #(when (check-route method path %) %) routes))

(defn get-handler [{:keys [method path]} routes]
  (:handler (find-route method path routes)))

(defn- add-route [server {:keys [method path]} main-handler]
  (.addRoute server method path main-handler))

(defn add-routes [server list-of-routes main-handler]
  (run! #(add-route server %  main-handler) list-of-routes))
