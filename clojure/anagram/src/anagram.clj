(ns anagram
  (:require [clojure.string :refer [lower-case upper-case]]))

(defn anagrams-for [word coll]

  (filter (fn [pool-word]
            (let [contains-all-letters (fn [w p]
                                         (every? #(.contains (seq w) %)
                                                 (seq p)))]
              (cond
                (or (= (upper-case word) word)
                    (= pool-word word)) false

                (let [word (lower-case word)
                      pool (lower-case pool-word)]
                  (and (contains-all-letters word pool)
                       (= (frequencies pool)
                          (frequencies word)))) pool-word))) coll)
  )
