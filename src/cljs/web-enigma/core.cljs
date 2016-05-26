(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [web-enigma.enigma :as enigma]))

(enable-console-print!)

(defonce app-state (atom ""))

(defn greeting []
  [:div.container
    [:div.card-panel
      [:h1 [:input#engima-input {
                    :type "text"
                    :value @app-state
                    :placeholder "text to encode"
                    :on-change #(reset! app-state (-> % .-target .-value))}]]]
    [:div.card-panel.deep-purple.lighten-2
      [:h4 "encoded text: " [:p (enigma/encode @app-state)]]]])

(r/render [greeting] (js/document.getElementById "app"))
