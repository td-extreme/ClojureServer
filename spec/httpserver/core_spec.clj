(ns game-of-life.core-spec
  (:require [speclj.core :refer :all]
            [httpserver.core :as httpserver]))

  (describe "display_welcom"
            (it "returns Http Server!"
                (let [message httpserver/display_welcome]
        (should= "Http Server!" message))))
