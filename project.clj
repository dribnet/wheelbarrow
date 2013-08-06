(defproject acute "0.0.1-SNAPSHOT"
  :description "wheelbarrow: experimental rickshaw library"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [net.drib/mrhyde "0.5.0"]]
  :min-lein-version "2.0.0"
  :source-paths ["src/clj" "src/cljs"]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {
    :builds [{
      :source-paths ["src/cljs"]
      :compiler {
        :output-to "public/out/wheelbarrow.js"
        :optimizations :whitespace
        :pretty-print true 
        ; :optimizations :simple
        }}]})
