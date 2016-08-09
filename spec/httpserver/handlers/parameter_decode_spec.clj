(ns httpserver.parameter-decode-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.parameter-decode :as parameter-decode]))

(describe "calling the handler"
  (it "returns a map with :body 'var_1 = @\nvar_2 = >' with arguments 'var_1 = %40&var_2 = %3E"
    (let [request {:method "GET" :path "parameters" :body "" :parameters "var_1 = %40&var_2 = %3E"}]
      (should= "var_1 = @\nvar_2 = >" (:body (parameter-decode/call request))))))
