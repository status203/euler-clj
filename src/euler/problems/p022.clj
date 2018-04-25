(ns euler.problems.p022
  (:require [clojure.string :as str]))

; Using names.txt, a 46K text file containing over five-thousand first names,
; begin by sorting it into alphabetical order. Then working out the alphabetical
; value for each name, multiply this value by its alphabetical position in the
; list to obtain a name score.
;
; For example, when the list is sorted into alphabetical order, COLIN, which is
; worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
; would obtain a score of 938 × 53 = 49714.
;
; What is the total of all the name scores in the file?

(let [letters (set (seq "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))
      scores (range 1 27)
      letter-scores (zipmap letters scores)
      score-word (fn [w] (->> (map letter-scores w) (reduce +)))]
  (->> (str/split (slurp "/home/adamas/dev/clj/euler/src/euler/problems/p022_names.txt") #",")
       (map #(filter letters %))
       (map #(apply str %))
       (sort-by identity)
       (map score-word)
       (map * (iterate inc 1))
       (reduce +)))

; => 871198282
