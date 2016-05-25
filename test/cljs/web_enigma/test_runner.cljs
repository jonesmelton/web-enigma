(ns web-enigma.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [web-enigma.core-test]))

(enable-console-print!)

(doo-tests 'web-enigma.core-test)
