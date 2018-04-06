(ns euler.problems.p009
  (:require [euler.math.numbers :refer [square]]))

; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
; a2 + b2 = c2
;
; For example, 32 + 42 = 9 + 16 = 25 = 52.
;
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(for [c (range 334 998)
      b (range (quot (- 1000 c) 2) (- 1000 c))
      a [(- 1000 c b)]
      :when (= (square c)
               (+ (square a) (square b)))]
  (* a b c))

