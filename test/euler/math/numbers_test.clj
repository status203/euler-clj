(ns euler.math.numbers-test
  (:require [clojure.test :refer :all]
            [euler.math.numbers :refer :all]))

; Fibonacci
(deftest fibonacci-first-five
  (testing "Testing first five entries")
  (are [m n expected] (= expected (take 5 (fibonacci m n)))
                      0 0 [0 0 0 0 0]
                      0 1 [0 1 1 2 3]
                      5 6 [5 6 11 17 28]))