(ns httpserver.parameter-decode-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.parameter-decode :as parameter-decode]))

(describe "decoding a parameter"
  (it "decode returns foo bar http://foo bar/ when http%3A%2F%2Ffoo%20bar%2F is passed in"
      (should= "http://foo bar/" (parameter-decode/decode "http%3A%2F%2Ffoo%20bar%2F"))))

(describe "building the body"
  (it "returns 'var_1=<\nvar_2=>' when 'var_1=%3C&var_2=%3E'"
      (should= "var_1=<\nvar_2=>" (parameter-decode/build-body "var_1=%3C&var_2=%3E"))))

(describe "calling the handler"
  (it "returns a map with :body 'var_1=@\nvar_2=>' with arguments 'var_1=%40&var_2=%3E"
    (let [request {:method "GET" :path "parameters" :body "" :parameters "var_1=%40&var_2=%3E"}]
      (should= "var_1=@\nvar_2=>" (:body (parameter-decode/call request))))))
