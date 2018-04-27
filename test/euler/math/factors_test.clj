(ns euler.math.factors-test
  (:require [clojure.test :refer :all]
            [euler.math.factors :refer :all]))


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

(deftest number-of-factors-test
  (are [n expected]
    (= expected (number-of-factors n))
    1 1
    2 2
    3 2
    6 4
    10 4
    15 4
    21 4
    28 6
    ))

(deftest amicable-test
  (are [n expected]
    (= expected (amicable n))
    1 nil
    2 nil
    6 nil
    28 nil
    220 [220 284]
    284 [220 284]
    ))

(deftest factors-test
  (are [n expected]
    (= expected (factors n))
    0 #{}
    1 #{1}
    2 #{1 2}
    8 #{1 2 4 8}
    16 #{1 2 4 8 16}
    60 #{1 2 3 4 5 6 10 12 15 20 30 60}
    220 #{1 2 4 5 10 11 20 22 44 55 110 220}))

(deftest proper-factors-test
  (are [n expected]
    (= expected (proper-factors n))
    0 #{}
    1 #{}
    2 #{1}
    8 #{1 2 4}
    16 #{1 2 4 8}
    60 #{1 2 3 4 5 6 10 12 15 20 30}
    220 #{1 2 4 5 10 11 20 22 44 55 110}))

(deftest perfect?-test
  (are [n expected]
    (= expected (perfect? n))
    1 false
    2 false
    6 true
    28 true
    30 false))

(deftest abundant?-test
  (are [n expected]
    (= expected (abundant? n))
    1 false
    12 true
    60 true
    112 true
    111 false))

(deftest deficient?-test
  (are [n expected]
    (= expected (deficient? n))
    1 true
    2 true
    6 false
    12 false
    111 true))