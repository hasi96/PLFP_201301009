(ns try.core
  (:gen-class))

(defn parse-int [s]
	;; Function to typecast string form of input into Big integer 
	(BigInteger. (re-find #"\d+" s))
)

(defn -main []
		(def pow (bigint 1))  ;; intermediate answer x^y nitialized to 1 
		(def i (bigint 0))    ;; loop variable
		(println "Enter x y z respectively.. x enter y enter z enter") 
		(let [x (read-line) y (read-line) z (read-line)]    ;; Reading x,y,z 	
	
;;loop starts here	  
	
(loop [i (parse-int y)]
	(when (> i 0)
		(def  pow (* pow (parse-int x)))
 	(recur (- i 1))))

;;loop ends here

(println (mod pow (parse-int z)))  ;; printing pow%z which is the final answer

))
	

