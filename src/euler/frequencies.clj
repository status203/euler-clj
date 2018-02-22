(ns euler.frequencies)

; Functions related to vectors, maps, and sets.

(defn upsert-frequency
  "If the supplied map does not contain value or has a lower freq then
  insert/update map with value/freq"
  [m value freq]
  (update-in m
             [value]
             (fn [old new] ((fnil max 0) old new))
             freq))

(defn expand-frequencies
  "Takes a map of frequencies and creates a vector with n copies of each key,
   where n is the frequency associated with the key. E.g. {:a 2, :b 1} would
   expand to [:a :a :b]"
  [freqs] (mapcat #(repeat (% 1) (% 0)) freqs))