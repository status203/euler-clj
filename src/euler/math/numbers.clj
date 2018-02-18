(ns euler.math.numbers)

(defn fibonacci
  "Creates an infinite lazy Fibonacci sequence starting with [m n]"
  ([] (fibonacci 0 1))
  ([m n] (lazy-seq (cons m
                   (fibonacci n (+' m n))))))
