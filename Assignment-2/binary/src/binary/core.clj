(ns binary.core
  (:gen-class))

(defn parse-int [s]
        ;; Function to typecast string form of input into integer
        (Integer. (re-find #"\d+" s))
)

(defn -main []
	(def answer "")
	(println "Enter the number:")
	(let [x (parse-int (read-line))] ;; Reading the user input, typecasting into Integer
	(loop [i x]
	   (when (> i 0)
		 (def remainder (mod i 2))   ;; calculate remainder
		  (def answer (concat answer (str remainder)))  ;; concat remainder to answer
 	   (recur (quot i 2) ))  ;; recur again with x<-x/2
)
(println (apply str (reverse answer)))) ;; print reverse of answer
)

