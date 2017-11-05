(ns rna-transcription
  (:require [clojure.string :refer [join]]))

(defn to-rna [character]

  (join (reduce (fn [rst x]
                  (conj rst (case (str x)
                              "G" "C"
                              "C" "G"
                              "T" "A"
                              "A" "U"
                              (throw (AssertionError. (str x))))))
                []
                (seq character)))
  )
