(ns practicalli.codewars.translate-roman-numerals.core)

(def relations {\I          1
                \V          5
                \X          10
                \L          50
                \C          100
                \D          500
                \M          1000})

(defn translate-roman-numerals [roman]
  (let [each-letter-val (->> roman
                             (map (fn [single-letter]
                                    (get relations single-letter)) ;Get arabic number for each letter))
                                  )
                             (filterv identity)              ;remove blank spaces if there is some
                             )
        num-letters (count each-letter-val)]
    (->> num-letters
         (range)
         (map (fn [i]
                (if
                  ;If the next numeral is greater than the current one, add the next one minus the current one
                  (and (< i (dec num-letters))
                       (< (nth each-letter-val i)
                          (nth each-letter-val (inc i))))
                  (* (get each-letter-val i)
                     -1)
                  ;Positive value if the next letter is smaller or it is the last letter
                  (get each-letter-val i))))
         (reduce +))))
