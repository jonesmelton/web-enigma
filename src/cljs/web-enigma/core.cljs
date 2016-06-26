(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [web-enigma.enigma :as enigma]
            [goog.dom :as dom]
            [goog.events :as events]))

(enable-console-print!)

(defonce user-input (atom ""))

(defn encrypt []
  [:div.container
    [:div.row
     [:div.card-panel.col.s1]
     [:div.card-panel.deep-purple-text.col.s2
      [:div.card-content
       [:h6.card-title "left rotor"]
       [:h3 (first (enigma/windows @user-input)) ]]]
     [:div.card-panel.col.s2]
     [:div.card-panel.deep-purple-text.col.s2
      [:div.card-content
       [:h6.card-title "center rotor"]
       [:h3 (second (enigma/windows @user-input)) ]]]
     [:div.card-panel.col.s2]
     [:div.card-panel.deep-purple-text.col.s2
      [:div.card-content
       [:h6.card-title "right rotor"]
       [:h3 (last (enigma/windows @user-input)) ]]]
     [:div.card-panel.col.s1]
     ]
    [:div.card-panel.input-field.deep-purple-text
      [:h2  [:input {
                    :type "text"
                    :value @user-input
                    :placeholder "text to encode"
                    :on-change #(reset! user-input (-> % .-target .-value))}]]
            [:label "Enigma Encoder"]
            [:div.card-action
              [:input {
                :type "button"
                :class "btn-flat waves-effect hoverable waves-purple"
                :value "clear"
                :on-click #(reset! user-input "")}]]]

    [:div.card-panel.deep-purple.lighten-4
      [:div.card-content
        [:h4.card-title "encoded text: "]
        [:p.flow-text (enigma/encode @user-input)]]]])


(r/render [encrypt] (js/document.getElementById "app"))
