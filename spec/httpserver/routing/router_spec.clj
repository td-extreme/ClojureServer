(ns httpserver.routing.router-spec
  (:require [speclj.core :refer :all]
            [httpserver.routing.router :as router]
            [httpserver.handlers.handler]))

(import '(com.td.HttpServer HttpServer))

(describe "Geting the handler function"
  (it "returns the appropriate handler function for the route requested"
    (let [test-list [{:method "GET" :path "/" :handler "GET / hanlder"}
                     {:method "GET" :path "/test" :handler :mock-test-handler}]
          request {:method "GET" :path "/test"}]
      (should= :mock-test-handler (router/get-handler request test-list))))
  (it "returns the appropriate handler function for the route where method matches and path is *"
    (let [test-list [{:method "GET" :path "/" :handler "GET * hanlder"}
                     {:method "GET" :path "/test" :handler :mock-test-handler}]
          request {:method "GET" :path "/test"}]
      (should= :mock-test-handler (router/get-handler request test-list)))))
