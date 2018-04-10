(ns euler.math.primes)

; Cannot include numbers ns as numbers includes primes.
(defn- divides?
  "Whether integer m divides integer n without a remainder"
  [m n] (zero? (mod m n)))

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