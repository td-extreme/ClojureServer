(ns httpserver.router-spec
  (:require [speclj.core :refer :all]
            [httpserver.router :as router]
            [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]))

(describe "routing"
  (it "picks the ok route for GET /tea"
    (let [request {:method "GET" :path "/tea"}]
      (should= ok/call (router/get-function request))))

  (it "picks the teapot route for GET /coffee"
    (let [request {:method "GET" :path "/coffee"}]
      (should= teapot/call (router/get-function request)))))
