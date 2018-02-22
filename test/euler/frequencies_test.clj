(ns euler.frequencies-test
  (:require [clojure.test :refer :all]
            [euler.frequencies :refer :all]))

(deftest upsert-frequency-test
  (are [m value freq expected]
    (= expected (upsert-frequency m value freq))
    {} :a 1 {:a 1}                                          ; no current value doesn't crash?
    {:b 2} :b 1 {:b 2}                                      ; doesn't overwrite with smaller?
    {:c 2} :c 2 {:c 2}                                      ; same freq has no effect?
    {:c 2} :c 3 {:c 3}                                      ; larger freq is used?
    {:d 1 :e 2} :d 3 {:d 3 :e 2}))                          ; updating one freq doesn't affect others?

(deftest expand-frequencies-test
  (are [freqs expected] (= expected (frequencies (expand-frequencies freqs)))
                        {} {}
                        {:a 0 :b 1} {:b 1}
                        {:c 3 :d 1 :e 4} {:c 3 :d 1 :e 4}))