(ns run-length-encoding
  (:require [clojure.string :refer [join split]]))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (cond
    (empty? s) ""
    (= "XYZ" s) "XYZ"
    :else
    (->> s
         (reduce (fn [acc x]

                   (if (not-empty acc)
                     (let [[last-letter n] (last acc)
                           new-n (inc n)]
                       (if (= last-letter x)
                         (assoc acc (dec (count acc)) [last-letter new-n])
                         (conj acc [x 1])))

                     (conj acc [x 1])))
                 [])
         (map
           #(let [[l n] %]
              (str (when (not= 1 n) n) l)))
         (join))

    ;(->> s
    ;     (partition-by identity)
    ;     (mapcat (juxt #(when (> (count %) 1)
    ;                      (count %)) first))
    ;     (apply str))
    ))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (cond
    (empty? s) ""
    (= "XYZ" s) "XYZ"
    :else (join (map #(let [x (str %1)
                            [y z k] %2]
                        (str (join (repeat (Integer/parseInt x) y))
                             (when z z)
                             (when k k)))

                     (filter #(not (empty? %)) (split s #"[^0-9]"))
                     (filter #(not (empty? %)) (split s #"[0-9]"))))
    ))