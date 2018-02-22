(ns euler.math.numbers-as-text)

(defn palindromic?
  "Returns whether n is palindromic"
  [n] (let [s (str n)]
        (= s (apply str (reverse s)))))

