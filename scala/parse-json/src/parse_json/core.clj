(ns parse-json.core
  (:require [cheshire.core :refer :all]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn parser []
  (parse-string (clojure.java.io/reader (clojure.java.io/resource "DLX_PAY_BY_LINK.json"))))