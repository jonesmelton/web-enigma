(ns web-enigma.core
  (:require [reagent.core :as r :refer [atom]]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello Chestnut!"}))

(defn greeting []
  [:h1 (:text @app-state)])

(r/render [greeting] (js/document.getElementById "app"))
