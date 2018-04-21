(ns euler.math.numbers-as-text)

(defn palindromic?
  "Returns whether n is palindromic"
  [n] (let [s (str n)]
        (= s (apply str (reverse s)))))

(defn sum-of-digits
  "Returns the sum of the (decimal) digits of n"
  ([n] (sum-of-digits n 0))
  ([n acc] (if (zero? n)
             acc                                            ; Base case
             (recur (quot n 10) (+ acc (mod n 10))))))

(def unit-words [nil "one" "two" "three" "four" "five" "six" "seven" "eight", "nine"])
(def teens-words ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen"
                  "sixteen" "seventeen" "eighteen" "nineteen"])
(def tens-words [nil nil "twenty" "thirty" "forty" "fifty" "sixty" "seventy"
                 "eighty" "ninety"])
(def number-position-words [nil "hundred" "thousand" "million" "billion" "trillion"
                            "quadrillion" "quintillion" "sextillion" "septillion"
                            "octillion" "nonillian" "decillion"])

(defn- sub-hundred-value-in-words
  "Returns nil if n is 0, otherwise the tens and units columns of n in words."
  [n] (let [units (mod n 10)
            tens (mod (quot n 10) 10)
            units-in-words (cond
                             (= tens 1) (teens-words units)
                             true (unit-words units))
            tens-in-words (tens-words tens)]
        (cond
          (and (not units-in-words) (not tens-in-words)) nil
          (and units-in-words tens-in-words) (str tens-in-words "-" units-in-words)
          true (str tens-in-words units-in-words))))

(defn number->triplets
  "Returns a vector of positional triplet values of n in increasing order of
  significance, e.g. 123,456,789 would return [789, 456, 123]"
  ([n] (number->triplets n []))
  ([n acc] (if (zero? n)
             acc
             (recur (quot n 1000) (conj acc (mod n 1000))))))

(defn- number->values
  "Returns a vector of positional values of n in increasing order of significance.
   e.g 987,123 would return [23, 1, 987]"
  [n] (concat [(mod n 100)
               (quot (mod n 1000) 100)]
              (number->triplets (quot n 1000))))

(defn number-in-words
  "Returns the wordy version of n e.g 4312 would return four thousand three hundred
  and twelve"
  [n]
  (->> (number->values n)
       (map #(if (zero? %) nil %))
       (map #(cond (not %) nil                              ; Keep nil as nil
                   (< % 100) (sub-hundred-value-in-words %) ; Convert 2 figures directly. Base case.
                   true (number-in-words %)))               ; Recurse (which will break 3 figures into single hundreds and double sub-hundred)
       (map #(if %2 (str %2
                         (if % " " nil)
                         %)
                    nil) number-position-words)             ; Concat value with positional word
       ((fn [[sh & rst]] (if (and sh (some identity rst))
                         (apply list sh "and" rst)          ; If has a sub-hundred value and any other value, insert an "and"
                         (apply list sh rst))))
       (filter identity)                                    ; Remove any nils
       reverse
       (interpose " ")
       (apply str)))

