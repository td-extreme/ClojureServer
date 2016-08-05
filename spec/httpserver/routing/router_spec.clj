(ns httpserver.routing.router-spec
  (:require [speclj.core :refer :all]
            [httpserver.routing.router :as router]
            [httpserver.handlers.handler]))

(import '(com.td.HttpServer HttpServer))

(describe "Checking if this is the route were are looking for"
  (it "returns false if the method does not match the one in map route"
    (should= false (router/check-route "PUT" "/path" {:method "GET" :path "/path"})))
  (it "returns false if the path does not match the one in map route"
    (should= false (router/check-route "GET" "/" {:method "GET" :path "/path"})))
  (it "returns false if the method and path do not match the ones in map route"
    (should= false (router/check-route "PUT" "/" {:method "GET" :path "/path"})))
  (it "returns true if the method and path match the ones in map route"
    (should= true (router/check-route "GET" "/path" {:method "GET" :path "/path"}))))

(describe "Finding our route inside a list of routes"
  (it "returns a map that contains the route and path we are looking for"
    (let [test-list (list {:method "GET" :path "/"}
                          {:method "GET" :path "/test"}
                          {:method "PUT" :path "/test"})]
      (should= {:method "GET" :path "/test"} (router/find-route "GET" "/test" test-list)))))

(describe "Geting the handler function"
  (it "returns the appropriate handler function for the route requested"
    (let [test-list (list {:method "GET" :path "/" :handler "GET / hanlder"}
                          {:method "GET" :path "/test" :handler "GET /test handler"})
          request {:method "GET" :path "/test"}]
      (should= "GET /test handler" (router/get-handler request test-list)))))
