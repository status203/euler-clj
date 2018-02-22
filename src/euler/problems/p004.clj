(ns euler.problems.p004
  (:require [euler.math.numbers-as-text :refer [palindromic?]]))

; A palindromic number reads the same both ways. The largest palindrome made from
; the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(->> (for [m (range 100 1000)
           n (range m 1000)]  (* m n))
     (filter palindromic?)
     (sort-by identity >)
     first)

; => 906609
