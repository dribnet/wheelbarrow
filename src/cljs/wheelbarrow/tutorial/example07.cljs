(ns wheelbarrow.tutorial.example07
  (:require [mrhyde.core :as mrhyde]
            [mrhyde.extend-js]))

(mrhyde/bootstrap)

(def Rickshaw (this-as ct (:Rickshaw ct)))

(def document js/document)

(def palette (Rickshaw.Color.Palette.))

(def graph (Rickshaw.Graph. {
  :element (-> document (.querySelector "#chart"))
  :width 780
  :height 500
  :renderer "line"
  :series [
    { :name "Northeast"
      :data [ { :x -1893456000 :y 25868573 } { :x -1577923200 :y 29662053 } { :x -1262304000 :y 34427091 } { :x -946771200 :y 35976777 } { :x -631152000 :y 39477986 } { :x -315619200 :y 44677819 } { :x 0 :y 49040703 } { :x 315532800 :y 49135283 } { :x 631152000 :y 50809229 } { :x 946684800 :y 53594378 } { :x 1262304000 :y 55317240 } ]
      :color (-> palette .color)
    }
    { :name "Midwest"
      :data [ { :x -1893456000 :y 29888542 } { :x -1577923200 :y 34019792 } { :x -1262304000 :y 38594100 } { :x -946771200 :y 40143332 } { :x -631152000 :y 44460762 } { :x -315619200 :y 51619139 } { :x 0 :y 56571663 } { :x 315532800 :y 58865670 } { :x 631152000 :y 59668632 } { :x 946684800 :y 64392776 } { :x 1262304000 :y 66927001 } ]
      :color (-> palette .color)
    }
    { :name "South"
      :data [ { :x -1893456000 :y 29389330 } { :x -1577923200 :y 33125803 } { :x -1262304000 :y 37857633 } { :x -946771200 :y 41665901 } { :x -631152000 :y 47197088 } { :x -315619200 :y 54973113 } { :x 0 :y 62795367 } { :x 315532800 :y 75372362 } { :x 631152000 :y 85445930 } { :x 946684800 :y 100236820 } { :x 1262304000 :y 114555744 } ]
      :color (-> palette .color)
    }
    { :name "West"
      :data [ { :x -1893456000 :y 7082086 } { :x -1577923200 :y 9213920 } { :x -1262304000 :y 12323836 } { :x -946771200 :y 14379119 } { :x -631152000 :y 20189962 } { :x -315619200 :y 28053104 } { :x 0 :y 34804193 } { :x 315532800 :y 43172490 } { :x 631152000 :y 52786082 } { :x 946684800 :y 63197932 } { :x 1262304000 :y 71945553 } ]
      :color (-> palette .color)
    }]}))

(def x_axis
  (Rickshaw.Graph.Axis.Time. { :graph graph }))

(def y_axis
  (Rickshaw.Graph.Axis.Y. {
    :graph graph
    :orientation "left"
    :tickFormat (get-in Rickshaw [:Fixtures :Number :formatKMBT])
    :element (-> document (.getElementById "y_axis"))}))

(def legend
  (Rickshaw.Graph.Legend. {
    :element (-> document (.querySelector "#legend"))
    :graph graph}))

(def offsetForm 
  (-> document (.getElementById "offset_form")))

(-> offsetForm (.addEventListener "change" (fn [e]
  (let [offsetMode (get-in e [:target :value])]
    (if (= offsetMode "lines") 
      (do
        (-> graph (.setRenderer "line"))
        (assoc! graph :offset "zero"))
      ; else
      (do
        (-> graph (.setRenderer "stack"))
        (assoc! graph :offset offsetMode))))
  (-> graph (.render))) false))

(-> graph .render)