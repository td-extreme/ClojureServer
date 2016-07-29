(ns httpserver.utilities.arguments
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [["-p" "--port PORT"
    :default 8080
    :parse-fn #(Integer/parseInt %)]
   ["-d" "--directory DIRECTORY"
    :default  "./"]])

(defn build-map [args]
   (parse-opts args cli-options))
