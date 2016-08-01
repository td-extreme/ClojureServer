(ns httpserver.ok-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.ok :as ok]))

(import '(com.td.HttpServer HttpResponse))

(describe "OkHandler"
  (it "returns an HttpRequest with code 200"
    (let [ok-handler (ok/new-ok-handler)
           response (.generateResponse ok-handler)]
      (should= 200 (.responseCode response)))))
