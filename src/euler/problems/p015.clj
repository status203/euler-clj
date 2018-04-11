(ns euler.problems.p015
  (:require [euler.math.numbers :refer [factorial]]))

; Starting in the top left corner of a 2×2 grid, and only being able to move to
; the right and down, there are exactly 6 routes to the bottom right corner.
;
; How many such routes are there through a 20×20 grid?

(defn lattice-path-count
  [m n] (/ (factorial (+ m n)) (factorial m) (factorial n)))

(defn p15 []
  (lattice-path-count 20 20))

; => 137846528820N