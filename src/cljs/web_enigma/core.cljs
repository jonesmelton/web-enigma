(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]
            [goog.dom :as dom]
            [goog.events :as events]))

(enable-console-print!)

(defonce app-state (atom "raw input"))

(defn greeting []
  [:div
    [:h1 [:input#engima-input {
                  :type "text"
                  :value @app-state
                  :placeholder "your thing here"
                  :on-change #(reset! app-state (-> % .-target .-value))}]]
    [:h2 "your translated text: " @app-state]])

(r/render [greeting] (js/document.getElementById "app"))
