(ns euler.problems.p016)

; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;
; What is the sum of the digits of the number 2^1000?

(defn p16 []
  (->> (repeat 1000 2)
       (apply *')
       str
       (map #(Integer/parseInt (str %)))
       (apply +')))

; => 1366
