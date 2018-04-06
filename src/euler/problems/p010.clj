(ns euler.problems.p010
  (:require [euler.math.primes :refer [primes]]))

; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

; Find the sum of all the primes below two million.

(apply +
       (take-while #(< % 2000000) (primes)))
