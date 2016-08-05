(ns httpserver.routing.router)

(defn check-route [method path route]
  (and (= (:method route) method) (= (:path route) path)))

(defn find-route [method path routes]
  (some #(when (check-route method path %) %) routes))

(defn get-handler [request routes]
  (:handler (find-route (:method request) (:path request) routes))
  )

(defn add-routes [server list-of-routes main-handler]
  (doseq [route list-of-routes]
    (.addRoute server (:method route) (:path route) main-handler)))
