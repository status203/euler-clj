(ns euler.math.numbers-as-text-test
  (:require [clojure.test :refer :all]
            [euler.math.numbers-as-text :refer :all]))

(deftest palindromic?-test
  (are [n expected] (= expected (palindromic? n))
                    0 true
                    1 true
                    11 true
                    12 false
                    1234547890 false
                    12345678987654321 true))