(ns recsys.eval
  (:require [clojure.string :as str]
            [clojure.java.io :as io])
  (:import [java.util Properties]
           [clojure.lang RT]
           [org.grouplens.lenskit.eval.script EvalScriptEngine]))

(defn -main
  [& args]
  (let [[script & args] args
        props (doto (Properties.)
                (.putAll (System/getProperties))
                (as-> props (doseq [arg args,
                                    :let [[key val] (str/split arg #"=")]]
                              (.setProperty props key val))))
        ese (EvalScriptEngine. (RT/makeClassLoader) props)]
    (.loadProject ese (io/file script))))
