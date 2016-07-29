(ns httpserver.arguments-spec
 (:require [speclj.core :refer :all]
           [httpserver.utilities.arguments :as argumenetParser]
           [clojure.tools.cli :refer [parse-opts]]))

(def args '("-p" "5000" "-d" "./site"))
(def argsEmpty '())

(describe "arguments"
  (it "sets port to 5000"
    (let [{:keys [options]} (argumenetParser/buildMap args)]
    (should= 5000 (:port options))))

  (it "set directory to ./site"
    (let [{:keys [options]} (argumenetParser/buildMap args)]
    (should= "./site" (:directory options))))

  (it "default port is 8080"
    (let [{:keys [options]} (argumenetParser/buildMap argsEmpty)]
    (should= 8080 (:port options))))

  (it "default directory is ./"
    (let [{:keys [options]} (argumenetParser/buildMap argsEmpty)]
    (should= "./" (:directory options)))))
