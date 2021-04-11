(ns practicalli.day1)

;--- Day 1: Report Repair ---
;After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.
;
;The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room.
;
;To save your vacation, you need to get all fifty stars by December 25th.
;
;Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
;
;Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.
;
;Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
;
;For example, suppose your expense report contained the following:
;
;1721
;979
;366
;299
;675
;1456
;In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
;
;Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?

(def data
  [1765
   1742
   1756
   1688
   1973
   1684
   1711
   1728
   1603
   1674
   1850
   1836
   1719
   1937
   1970
   1770
   1954
   1848
   1885
   1851
   1474
   1801
   1769
   1904
   1906
   1739
   1717
   1830
   1985
   1930
   1791
   1977
   1713
   1787
   1773
   1672
   1750
   1931
   1807
   1762
   1835
   1736
   1979
   1923
   1782
   1797
   1822
   1903
   1729
   343
   1678
   1753
   1873
   1358
   1987
   1821
   1761
   1988
   1886
   1669
   857
   1894
   1404
   1909
   1789
   1752
   1882
   1969
   1892
   1701
   1956
   1839
   483
   1897
   1730
   1829
   1879
   1810
   1755
   1799
   1932
   1715
   1809
   418
   1896
   1691
   1749
   1922
   1631
   1780
   1734
   1859
   1695
   1548
   1948
   1997
   1921
   1994
   1369
   1364
   1764
   1697
   1833
   1239
   616
   1786
   1890
   677
   1867
   1705
   1993
   1925
   1774
   1732
   1686
   1847
   1911
   1841
   1962
   1907
   1919
   1725
   1687
   1236
   1864
   1855
   1928
   1941
   1709
   1683
   1676
   1889
   1982
   1595
   1735
   1857
   1731
   1816
   2003
   1724
   741
   1655
   1308
   1959
   1955
   1768
   1795
   1804
   1961
   1693
   1884
   1813
   1927
   1845
   1689
   1646
   1803
   2008
   1599
   1984
   1871
   1814
   1918
   1990
   1858
   1908
   1949
   1980
   1618
   1718
   1712
   1989
   1876
   1947
   1974
   1838
   1865
   1842
   1817
   680
   1986
   1812
   1895
   1991
   1644
   1877
   1880
   1792
   1800
   1899
   1806
   1699
   1685
   1793
   1647
   1429
   1751
   1722
   1887
   1968])

(defn main []
  (->> data
       (filter (fn [e]
                 (->>
                   data
                   (some #(= (+ e %) 2020)))))
       (reduce *)))

#_(practicalli-clojure.day1/main)

;--- Part Two ---
;The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.
;
;Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.
;
;In your expense report, what is the product of the three entries that sum to 2020?




(defn main2 []
  (let [data2 (->> data
                   (map (fn [e]
                          (->>
                            data
                            (map (fn [e2]
                                   (+ e e2))))))
                   flatten)]
    (->> data
         (filter (fn [e]
                   (->>
                     data2
                     (some (fn [e2]
                             (= (+ e e2) 2020))))))
         (reduce *))))

#_(practicalli-clojure.day1/main2)