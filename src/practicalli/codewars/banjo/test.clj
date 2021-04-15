(ns practicalli.codewars.banjo.test
  (:require [clojure.test :refer :all]
            [practicalli.codewars.banjo.core :as b]))

(deftest Banjo-test
  (is (= (b/plays-banjo? "Adam") "Adam does not play banjo"))
  (is (= (b/plays-banjo? "Paul") "Paul does not play banjo"))
  (is (= (b/plays-banjo? "Ringo") "Ringo plays banjo"))
  (is (= (b/plays-banjo? "bravo") "bravo does not play banjo"))
  (is (= (b/plays-banjo? "rolf") "rolf plays banjo"))
  )