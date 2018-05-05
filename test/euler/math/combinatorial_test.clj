(ns euler.math.combinatorial_test
  (:require [clojure.test :refer :all]
            [euler.math.combinatorial :refer :all]))

(deftest number-of-permutations-test
  (are [n expected]
    (= expected (number-of-permutations n))
    [:a] 1
    (seq "01") 2
    '(0 1 2) 6))

(deftest nth-permutation-test
  (are [s n expected]
    (= expected (nth-permutation s n))
    (seq "ab") 0 (seq "ab")
    [:a :b] 1 [:b :a]
    (seq "012") 2 (seq "102")
    [0 1 2] 5 [2 1 0]))

