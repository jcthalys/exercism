(ns reverse-string
  (:require [clojure.string :as s]))

(defn reverse-string [value] ;; <- arglist goes here
  (s/reverse value))
