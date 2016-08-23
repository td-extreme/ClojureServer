(ns httpserver.delete-form-spec
  (:require [speclj.core :refer :all]
            [httpserver.handlers.delete-form :as delete-form]))

(import '(java.io File))

(describe "deleteing form"
  (it "retuns a mape with :code 200"
    (.createNewFile (new File "./form"))
    (should= 200 (:code (delete-form/call {:method "DELETE" :path "/form"} ".")))))
