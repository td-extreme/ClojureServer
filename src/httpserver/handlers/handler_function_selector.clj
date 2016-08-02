(ns httpserver.handlers.handler_function_selector
  (:require [httpserver.handlers.ok :as ok]
            [httpserver.handlers.teapot :as teapot]))

(defn get-function [request]
  (cond
    (= true (= (= "GET" (:method request)) (= "/coffee" (:path request)))) teapot/call
    (= true (= (= "GET" (:method request)) (= "/tea" (:path request)))) ok/call))
