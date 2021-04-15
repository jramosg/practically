(ns practicalli.codewars.string-ends-with.core
  (:require
    [clojure.string :refer (ends-with?)]))

;Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).
;
;Examples:
;
;(solution "abc" "bc") ; returns true
;(solution "abc" "d'" ; returns false

(defn solution [strng ending]
  (or
    (= strng ending)
    (if (> (count strng)
           (count ending))
      (= (subs strng
               (- (count strng)
                  (count ending))
               (count strng))
         ending)
      false)))

;Other solution with clojure.string

(defn solution2 [strng ending]
  (ends-with? strng ending))