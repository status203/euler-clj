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

(deftest number->triplets-test
  (are [n expected] (= expected (number->triplets n))
    0 []
    1 [1]
    10 [10]
    111 [111]
    999 [999]
    123456789 [789 456 123]))

(deftest number-in-words-test
  (are [n expected]
    (= expected (number-in-words n))
    1 "one" 5 "five" 9 "nine"
    10 "ten" 15 "fifteen" 19 "nineteen"
    20 "twenty", 21 "twenty-one", 25 "twenty-five" 29 "twenty-nine"
    99 "ninety-nine"
    100 "one hundred"
    101 "one hundred and one"
    111 "one hundred and eleven"
    320 "three hundred and twenty"
    999 "nine hundred and ninety-nine"
    1000 "one thousand"
    1001 "one thousand and one"
    300000002 "three hundred million and two"
    500000000 "five hundred million"
    123456789 "one hundred and twenty-three million four hundred and fifty-six thousand seven hundred and eighty-nine"
    ))

(deftest sum-of-digits-test
  (are [n expected]
    (= expected (sum-of-digits n))
    0 0
    1 1
    9 9
    10 1
    98 17
    100 1
    1234567890 45))