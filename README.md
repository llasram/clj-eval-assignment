# clj-eval-assignment

Clojure port of Coursera/UMN “Introduction to Recommender Systems” course
project template for Programming Assignment 4 / “Evaluation.”

The Leiningen `project.clj` for this project includes an alias for running the
assignment evaluation Groovy script.  Run it as:

    $ lein lenskit-eval [PROPERTIES...]
    
The additional `PROPERTIES` arguments may be any number of additional
property-name/-value pairs, as per additional `-D` property-specification
arguments to the `lenskite-val` Maven task.  For example:

    $ lein lenskit-eval lenskit.eval.threadCount=4
    
The one code aspect of this assignment (the tag entropy metric calculation) may
be implemented in the `recsys.metric` namespace.
