(ns armstrong-numbers)


(defn get-num-digits [^Integer n]
  (map #(Character/getNumericValue ^Character %) (str n)))


(defn armstrong? [n]
  (let [num-digits (count (str n))
        digits (get-num-digits n)]
    (= n
       (->> digits
            (map #(Math/pow % num-digits))
            (reduce +)
            (int)))))