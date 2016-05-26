(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [web-enigma.enigma :as enigma]))

(enable-console-print!)

(defonce app-state (atom ""))

(defn greeting []
  [:div
    [:h1 [:input#engima-input {
                  :type "text"
                  :value @app-state
                  :placeholder "text to encode"
                  :on-change #(reset! app-state (-> % .-target .-value))}]]
    [:h2 "encoded text you made: " (enigma/encode @app-state)]])

(r/render [greeting] (js/document.getElementById "app"))
