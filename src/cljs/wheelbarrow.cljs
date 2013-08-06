(ns wheelbarrow
  (:require [mrhyde.core :as mrhyde]))

(def Rickshaw (this-as ct (aget ct "Rickshaw")))

(defn ^:export bootstrap []
  (mrhyde/bootstrap))
