(ns httpserver.handler_function_selector_spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.handler_function_selector :as selector]
            [httpserver.handlers.teapot :as teapot]
            [httpserver.handlers.ok :as ok]))

(describe "routing"
  (it "picks the ok route for GET /tea"
    (let [request {:method "GET" :path "/tea"}]
      (should= ok/call (selector/get-function request))))

  (it "picks the teapot route for GET /coffee"
    (let [request {:method "GET" :path "/coffee"}]
      (should= teapot/call (selector/get-function request)))))
