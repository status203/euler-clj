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