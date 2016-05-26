(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [web-enigma.enigma :as enigma]
            [goog.dom :as dom]
            [goog.events :as events]))

(enable-console-print!)

(defonce app-state (atom ""))

(defn greeting []
  [:div.container
    [:div.card-panel.input-field.deep-purple-text
      [:h2  [:input {
                    :type "text"
                    :value @app-state
                    :placeholder "text to encode"
                    :on-change #(reset! app-state (-> % .-target .-value))}]]
            [:label "Enigma Encoder"]
            [:input {
              :type "button"
              :class "waves-effect waves-purple btn-flat"
              :value "clear"
              :on-click #(reset! app-state "")
              }]]

    [:div.card-panel.deep-purple.lighten-2
      [:h4 "encoded text: " [:p (enigma/encode @app-state)]]]])

(r/render [greeting] (js/document.getElementById "app"))
