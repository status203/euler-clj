(ns euler.math.primes-test
  (:require [clojure.test :refer :all]
            [euler.math.primes :refer :all]))


(deftest naive-prime-checking
  (testing "correctly divines primeness"
    (are [n expected] (= expected (naive-prime? n))
                      0 false
                      1 false
                      2 true
                      3 true
                      4 false
                      9 false
                      97 true)))

(deftest primes-by-filter-test
  (testing "First 10 primes correctly calculated"
    (is (= [2 3 5 7 11 13 17 19 23 29] (take 10 (primes-by-filter))))))

(deftest prime-factors-test
  (testing "Prime factors calculated correctly"
    (are [n expected] (= expected (prime-factors n))
                      0 []
                      1 []
                      2 [2]
                      5 [5]
                      8 [2 2 2]
                      18 [2 3 3]
                      17 [17])))