(ns practicalli.codewars.arge.core-test
  (:require [clojure.test :refer :all]
            [practicalli.codewars.arge.core :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "nb-year"
    (test-assert(nb-year 1500, 5, 100, 5000), 15)
    (test-assert(nb-year 1500000, 2.5, 10000, 2000000), 10)
    (test-assert(nb-year 1500000, 0.25, 1000, 2000000), 94)

    ))

