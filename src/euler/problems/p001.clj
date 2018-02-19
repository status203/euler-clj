(ns euler.problems.p001)

; Find the sum of all the multiples of 3 or 5 below 1000.

(def up-to 1000)
(->> (range 1 up-to)
     (filter #(or (= 0 (mod % 3))
                  (= 0 (mod % 5))))
     (apply +))

; 233168