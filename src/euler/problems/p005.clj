(ns euler.problems.p005
  (:require [euler.math.factors :refer [prime-factors]]
            [euler.frequencies :refer [upsert-frequency expand-frequencies]]))

; 2520 is the smallest number that can be divided by each of the numbers from
; 1 to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all of the
; numbers from 1 to 20?


(defn p5 []
  (->> (range 1 21)
             (mapcat (comp frequencies prime-factors))
             (reduce #(apply upsert-frequency %1 %2) {})    ; %2 is [value freq]
             expand-frequencies
             (reduce *)))

; => 232792560