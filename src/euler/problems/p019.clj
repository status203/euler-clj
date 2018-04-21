(ns euler.problems.p019)

; You are given the following information, but you may prefer to do some
; research for yourself.
;
; 1 Jan 1900 was a Monday.
; Thirty days has September,
; April, June and November.
; All the rest have thirty-one,
; Saving February alone,
; Which has twenty-eight, rain or shine.
; And on leap years, twenty-nine.
; A leap year occurs on any year evenly divisible by 4, but not on a century
; unless it is divisible by 400.
;
; How many Sundays fell on the first of the month during the twentieth century
; (1 Jan 1901 to 31 Dec 2000)?

(defn leap-year?
  [y] (cond (zero? (mod y 400)) true
            (zero? (mod y 100)) false
            (zero? (mod y 4)) true
            :else false))

(defn days-in-month
  [[y m]] (let [month-days [31 (if (leap-year? y) 29 28) 31 30 31 30
                            31 31 30 31 30 31]]
            (month-days (dec m))))

(defn p19 []
  (->> (for [y (range 1901 2001) m (range 1 13)]
         [y m])
       drop-last
       (map days-in-month)
       (reductions + 1)
       (map #(mod % 7))
       (filter #(= % 6))
       count))

; => 171