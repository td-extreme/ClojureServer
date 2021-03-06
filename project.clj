(defproject httpserver "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["lib/HttpServer-0.1.6.jar"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 ]

  :plugins [[speclj "3.3.1"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]} :uberjar {:aot :all}}
  :test-paths ["spec"]
  :main httpserver.core
  )
