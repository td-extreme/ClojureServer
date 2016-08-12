(ns httpserver.file-type-checker-spec
  (:require [speclj.core :refer :all]
            [httpserver.file-io.file-type-checker :as file-type-checker]))

(describe "Testing if a file exists"
  (it "returns false for . /foobar"
    (should= false (file-type-checker/file-exists "." "/foobar")))
  (it "returns true for . /"
    (should= true (file-type-checker/file-exists "." "/"))))

(describe "Testing if a path is a direcoty"
  (it "returns false fo '.' '/foobar'"
    (should= false (file-type-checker/is-dir "." "/foobar")))
  (it "returns false for 'folder_for_io_testing' 'this_is_a_dir/file.txt'"
    (should= false (file-type-checker/is-dir "./folder_for_io_testing" "/this_is_a_dir/file.txt")))
   (it "returns true for 'folder_for_io_testing' 'this_is_a_dir/"
    (should= true (file-type-checker/is-dir "./folder_for_io_testing" "/this_is_a_dir"))))

(describe "Testing if a path is a file"
  (it "returns false fo '.' '/foobar'"
    (should= false (file-type-checker/is-file "." "/foobar")))
  (it "returns false for 'folder_for_io_testing' 'this_is_a_dir/"
    (should= false (file-type-checker/is-file "./folder_for_io_testing" "/this_is_a_dir")))
  (it "returns true for 'folder_for_io_testing' 'this_is_a_dir/file.txt'"
    (should= true (file-type-checker/is-file "./folder_for_io_testing" "/this_is_a_dir/file.txt"))))


