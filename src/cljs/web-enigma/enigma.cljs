(ns web-enigma.enigma
  (:require [web-enigma.staticparts :as parts]
            [web-enigma.inputoutput :as translate]
            [web-enigma.rotorops :as rotor]))

(defn translate-string [string rotatoes]
  (loop [remaining-letters  (translate/validate-str string)
         encoded-letters    []
         rotors             (translate/step rotatoes)]
    (if-not (seq remaining-letters)
      (apply str encoded-letters)
      (let [[first-char & rest] remaining-letters]
        (recur rest (conj encoded-letters (translate/single-lap first-char rotors)) (translate/step rotors))))))

(defn encode [& rest] (translate-string (clojure.string/upper-case (apply str rest)) parts/grounded-rotors ))

(defn windows [& rest] (translate/translate-rotor (clojure.string/upper-case (apply str rest)) parts/grounded-rotors ))

(defn -main
  [& rest]
  (println (translate-string (clojure.string/upper-case (apply str rest)) parts/grounded-rotors ))
  )
