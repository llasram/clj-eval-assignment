(defproject clj-eval-assignment "0.1.0-SNAPSHOT"
  :description "Clojure port of `eval-assignment` template."
  :url "http://github.com/llasram/clj-eval-assignment"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.6" "-source" "1.6"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.codehaus.jsr166-mirror/jsr166y "1.7.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.grouplens.lenskit/lenskit-core "2.0.3.2"]
                 [org.grouplens.lenskit/lenskit-knn "2.0.3.2"]
                 [org.apache.lucene/lucene-core "3.5.0"]
                 [org.apache.lucene/lucene-queries "3.5.0"]
                 [org.apache.lucene/lucene-analyzers "3.5.0"]
                 [org.platypope/parenskit "0.1.0"]
                 [org.slf4j/slf4j-api "1.7.5"]
                 [org.slf4j/slf4j-log4j12 "1.7.5"]
                 [log4j "1.2.17"]]
  :aliases {"lenskit-eval" ;; Should become a plugin, but this works for now
            ["run" "-m" "recsys.eval" "./eval/eval.groovy"
             "project.build.sourceEncoding=UTF-8"
             "lenskit.eval.dataDir=./data/"
             "lenskit.eval.scriptDir=./eval/"
             "lenskit.eval.analysisDir=./target/analysis/"]}
  :profiles {:uberjar {:aot :all}
             :provided {:dependencies
                        [[org.grouplens.lenskit/lenskit-eval "2.0.3.2"]]}
             :dev {:dependencies
                   [[com.google.code.findbugs/annotations "2.0.2"]]}})
