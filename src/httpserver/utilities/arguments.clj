(ns httpserver.utilities.arguments
  (:require [clojure.tools.cli :as cli]))

(def cli-options
  [["-p" "--port PORT"
    :default 8080
    :parse-fn #(Integer/parseInt %)]
   ["-d" "--directory DIRECTORY"
    :default  "./"]])

(defn build-map [args]
   (cli/parse-opts args cli-options))
