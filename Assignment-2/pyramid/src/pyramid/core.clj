(ns pyramid.core
  (:gen-class))

(defn parse-int [s]			     ;; Input from the user is a String type, this function converts it into an integer
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn printstars [x] "Used to print stars of decreasing numbers"(loop [i x] (when (> i 0) (print "* ")(recur (- i 1)))))

(defn pyramid [n] (loop [x n] (when (> x 0) (loop [j (+ 1 (- n x))] (when (> j 0) (print " ") (recur (- j 1))))(printstars x)(println)(recur (- x 1)))))
					    
(defn -main
  "Main Function"
  [& args]     	
  (println "Enter any number")
  (def a (read-line))	        	     ;; Taking Input from the user as a string 
  (println (pyramid (parse-int a))))	     ;; Converting the string into an integer and passing it as a parameter to the pyramid function
