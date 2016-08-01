(ns httpserver.ok-spec
  (:require  [speclj.core :refer :all]
            [httpserver.handlers.ok :as ok]))

(import '(com.td.HttpServer HttpResponse))

(describe "teapotHandler"
  (it "returns an HttpRequest with code 200"
    (let  [testOk  (ok/new-ok-handler)
           response  (.generateResponse testOk)]
      (should= 200  (.responseCode response)))))
