(ns bob
  (:require [clojure.string :refer [blank? ends-with?]]))





(defn silent? [phrase]
  (blank? phrase))

(defn upper-case-phrase? [phrase]
  (and (= (clojure.string/upper-case phrase)
          phrase)
       (re-find #"[A-Z]+" phrase)))


(defn questions? [phrase]
  (ends-with? phrase "?"))

(defn response-for [phrase]
  (cond
    (silent? phrase) "Fine. Be that way!"
    (upper-case-phrase? phrase) "Whoa, chill out!"
    (questions? phrase) "Sure."
    :else "Whatever."))


(def a (blank?))