(ns euler.problems.p003
  (:require [euler.math.primes :refer [prime-factors]]))

; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?

(def number 600851475143)

(peek (prime-factors number))

; 6857