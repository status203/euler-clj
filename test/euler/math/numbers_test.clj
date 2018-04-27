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

(deftest factorial-test
  (are [n expected]
    (= expected (factorial n))
    1 1
    2 2
    3 6
    6 720))

