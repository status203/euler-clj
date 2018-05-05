(ns euler.math.factors
  (:require [clojure.math.combinatorics :as combo]
            [euler.math.numbers :refer [divides?]]))

(defn naive-prime?
  "Checks whether n is prime by seeing if all integers lower or equal to n
  divide n"
  [n] (if (< n 2)
        false
        (->> (range 2 (inc (Math/floor (Math/sqrt n))))
            (filter #(divides? n %))
            empty?)))

(defn primes-by-filter
  "Generates a lazy infinite sequence of primes by checking each integer with
  a primeness test"
  [] (->> (range)
          (filter naive-prime?)))

(defn primes
  "Returns a lazy infinite list of primes"
  [] (primes-by-filter))

(defn prime-factors
  "Returns a vector of prime factors of n"
  ([n] (prime-factors n (primes)))
  ([n possible-factors]
   (loop [m n
          factors []
          possible-factors possible-factors]
     (if (<= m 1)
       factors
       (let [[factor & rest-factors] possible-factors]
         (if (divides? m factor)
           (recur (/ m factor) (conj factors factor) possible-factors)
           (recur m factors rest-factors)))))))

(defn number-of-factors
  "How many factors n has; calculated from possible number of prime factor combinations"
  ([n] (number-of-factors n (primes)))
  ([n possible-factors] (->> (prime-factors n possible-factors)
                             frequencies
                             (map #(-> % second inc))
                             (apply *))))

(defn factors
  "Returns a set of the factors of n"
  ([n] (factors n (primes)))
  ([n possible-factors] (if (zero? n)
                          #{}
                          (->> (prime-factors n possible-factors)
                               combo/subsets
                               (map #(apply * %))
                               set))))

(defn proper-factors
  "Returns a set of the proper factors of n"
  ([n] (proper-factors n (primes)))
  ([n possible-factors] (-> n
                            (factors possible-factors)
                            (disj n))))

(defn amicable
  "If n is amicable returns a vector of n and it's partner in increasing order,
   otherwise returns nil"
  ([n] (amicable n (primes)))
  ([n possible-factors]
   (let [n-partner (->> (proper-factors n possible-factors) (reduce +))
         n-partner-partner (->> (proper-factors n-partner possible-factors) (reduce +))]
     (if (and (= n n-partner-partner) (not= n n-partner)) (sort [n n-partner])))))

(defn perfect?
  "Returns whether n is a perfect number i.e. the sum of n's proper factors
  equals n"
  ([n] (perfect? n (primes)))
  ([n possible-factors] (= n (reduce + (proper-factors n possible-factors)))))

(defn abundant?
  "Returns whether n is abundant, i.e. the sum of n's proper factors is greater
  than n"
  ([n] (abundant? n (primes)))
  ([n possible-factors] (< n (reduce + (proper-factors n possible-factors)))))

(defn deficient?
  "Returns whether n is deficient, i.e. the sum of n's proper factors is less
  than n"
  ([n] (deficient? n (primes)))
  ([n possible-factors] (> n (reduce + (proper-factors n possible-factors)))))