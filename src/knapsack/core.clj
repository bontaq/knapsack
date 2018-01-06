(ns knapsack.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn -main
  [& args]
  (println args))

(defn readFile [name]
  (slurp name))

(defn parseFile [name]
  (let [f (readFile name)]
    (str/split f #"\n")))

(defn lines->parts [lines]
  (let [split-lines (map (fn [line] (str/split line #" ")) lines)
        numberized-lines (map (fn [row] (map read-string row)) split-lines)]
    {:number-items (first (first numberized-lines))
     :capacity (second (first numberized-lines))
     :items (rest numberized-lines)}))

(defn total-weight [lines]
  (let [first-then-add (fn [acc w] (+ acc (second w)))]
    (reduce first-then-add 0 lines)))

;; interface Problem {
;;   number-items: number
;;   capacity: number
;;   items: Array[[value, weight]]
;; }

(defn garbage-solution [problem]
  (let [{:keys [items capacity]} problem
        t (println items)]
    (reduce (fn [acc item]
              (if (< (total-weight acc) capacity)
                (concat acc [item])
                acc))
            []
            items)))

(garbage-solution
 (lines->parts
  (parseFile "./data/ks_4_0")))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
