(ns palin.core
  (:gen-class))

  (use 'clojure.pprint)
(defn -main
  [& args]
  (println "Enter the input strings one after the other")
  (def a (read-line))
  (def b (read-line))	
  (def s (str a b))
;;DP based solution
(let [the-array (make-array Long/TYPE (count s) (count s))]         
  (loop [ii 0 jj 0]      ;;Strings of length 1 are palindromes of length 1  
  (when (and  (and (= ii jj) (< ii (count s))) (< jj (count s)))
    (aset the-array ii jj 1)
    (recur (+ ii 1)(+ jj 1))))
    (loop [m 2] (when (< m (+ 1 (count s))) 
      (loop [n 0] (when (< n (- (+ 1 (count s)) m))
         (def c (- (+ n m) 1))
	 (if (and (= (get s n) (get s c)) (= m 2)) (aset the-array n c 2) (if (= (get s n) (get s c)) (aset the-array n c (+ 2 (aget the-array (+ n 1) (- c 1)))) (aset the-array n c (max (aget the-array n (- c 1)) (aget the-array (+ 1 n) c)))))
      (recur (+ 1 n))))
    (recur (+ 1 m))))
(println (aget the-array 0 (- (count s) 1)))
))
