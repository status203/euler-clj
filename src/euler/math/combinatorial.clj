(ns euler.math.combinatorial
  (:require [euler.math.numbers :refer [factorial]]))

; Currently assumes sequential collections of items are unique.
; indexes start at 0

; Trivially wraps another fn but aids readability
(defn number-of-permutations
  "Returns the number of permutations of a sequence of items"
  [items] (factorial (count items)))

(defn nth-permutation
  "Returns the nth lexicographic permutation of supplied sequence of items"
  [items n] (if (= 1 (count items))
          items
          (let [number-of-sub-perms (factorial (dec (count items)))
                first-item-pos (quot n number-of-sub-perms)
                first-item (nth items first-item-pos)
                rest-items (concat (take first-item-pos items)
                                    (drop (inc first-item-pos) items))]
            (cons first-item (nth-permutation rest-items
                                               (mod n number-of-sub-perms))))))
