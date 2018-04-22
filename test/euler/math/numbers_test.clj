(ns euler.math.numbers-test
  (:require [clojure.test :refer :all]
            [euler.math.numbers :refer :all]))

; Fibonacci
(deftest fibonacci-first-five
  (testing "Testing first five entries"
    (are [m n expected] (= expected (take 5 (fibonacci m n)))
                        0 0 [0 0 0 0 0]
                        0 1 [0 1 1 2 3]
                        5 6 [5 6 11 17 28])))

(deftest divides?-test
  (testing "whether one int divides another without remainder"
    (are [m n expected] (= expected (divides? m n))
                        1 1 true
                        2 1 true
                        1 2 false
                        20 5 true
                        23 5 false)))

(deftest square-test
  (are [n expected]
    (= expected (square n))
    0 0
    1 1
    10 100
    -2 4))

(deftest arithmetic-progression-test
  (are [start delta expected]
    (= expected (take 5 (arithmetic-progression start delta)))
    1 1 [1 2 3 4 5]
    4 3 [4 7 10 13 16]))

(deftest triangular-numbers-test
  (is (= [1 3 6 10 15] (take 5 (triangular-numbers)))))

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

(deftest factorial-test
  (are [n expected]
    (= expected (factorial n))
    1 1
    2 2
    3 6
    6 720))

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