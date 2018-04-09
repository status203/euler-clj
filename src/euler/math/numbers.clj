(ns euler.math.numbers
  (:require [euler.math.primes :as primes]))

(defn fibonacci
  "Creates an infinite lazy Fibonacci sequence starting with [m n]"
  ([] (fibonacci 0 1))
  ([m n] (lazy-seq (cons m
                   (fibonacci n (+' m n))))))

(defn divides?
  "Whether integer m divides integer n without a remainder"
  [m n] (zero? (mod m n)))

(defn square
  [n] (*' n n))

(defn arithmetic-progression
  "Infinite lazy sequence of an arithmetic progression"
  [start delta] (lazy-seq (cons start (arithmetic-progression (+ start delta) delta))))

(defn triangular-numbers
  "Infinite lazy sequence of triangular numbers"
  [] (reductions + (arithmetic-progression 1 1)))

(defn number-of-factors
  "How many factors n has; calculated from possible number of prime factor combinations"
  [n] (->> (primes/prime-factors n)
           frequencies
           (map #(-> % second inc))
           (apply *)))