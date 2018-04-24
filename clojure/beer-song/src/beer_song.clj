(ns beer-song)

(def template "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottles of beer on the wall.\n")

(defn verse
  [n]
  (condp = n
    2 "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    1 "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    0 "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    (format template n n (dec n))))

(defn sing
  ([from] (sing from 0))
  ([from to]
   (clojure.string/join "\n" (map verse (reverse (range to (inc from)))))))