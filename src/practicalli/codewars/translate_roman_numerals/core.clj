(ns practicalli.codewars.translate-roman-numerals.core)

;Create a function that takes a Roman numeral as its argument and returns its value as a numeric decimal integer. You don't need to validate the form of the Roman numeral.
;
;Modern Roman numerals are written by expressing each decimal digit of the number to be encoded separately, starting with the leftmost digit and skipping any 0s. So 1990 is rendered "MCMXC" (1000 = M, 900 = CM, 90 = XC) and 2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). The Roman numeral for 1666, "MDCLXVI", uses each letter in descending order.
;
;Example:
;
;(translate-roman-numerals "XXI") ;; should return 21
;Help:
;
;Symbol    Value
;I          1
;V          5
;X          10
;L          50
;C          100
;D          500
;M          1,000
;Courtesy of rosettacode.org

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
