(ns httpserver.arguments-spec
  (:require [speclj.core :refer :all]
            [httpserver.utilities.arguments :as arguments]))

(def args '("-p" "5000" "-d" "./site"))
(def argsEmpty '())

(describe "arguments"

  (let  [args  ["-p" "5000" "-d" "./site"]]
    (it "sets port to 5000"
      (let [{:keys [options]} (arguments/build-map args)]
        (should= 5000 (:port options)))

      (it "set directory to ./site"
        (let [{:keys [options]} (arguments/build-map args)]
          (should= "./site" (:directory options))))))

    (let [empty-args '()]
      (it "default port is 8080"
        (let [{:keys [options]} (arguments/build-map argsEmpty)]
          (should= 8080 (:port options))))

      (it "default directory is ./"
        (let [{:keys [options]} (arguments/build-map argsEmpty)]
          (should= "./" (:directory options))))))
