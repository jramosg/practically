(ns practicalli.codewars.arge.core)

(def counter (atom 0))
(def new-p0 (atom nil))

(defn nb-year [p0 percent aug p]
  (reset! new-p0 p0)
  (reset! counter 0)
  (doall (while (< @new-p0 p)
           (reset! new-p0
                   (->> (+ @new-p0
                           (* @new-p0 (/ percent 100))
                           aug)
                        (Math/floor)))
           (swap! counter inc)))
  @counter)