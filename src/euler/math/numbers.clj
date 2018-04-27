(ns euler.math.numbers)

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

(defn factorial
  "The factorial of n, i.e n * n-1 * n-2 ... * 1"
  ([n] (factorial n 1))
  ([n total] (if (= n 1)
               total
               (recur (dec n) (*' total n)))))
