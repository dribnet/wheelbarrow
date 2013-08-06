(ns wheelbarrow.tutorial.example07
  (:require [cljs.reader :refer [read-string]]
            [wheelbarrow :refer [Rickshaw bootstrap]]))

(bootstrap)

(-> js/graph .render)