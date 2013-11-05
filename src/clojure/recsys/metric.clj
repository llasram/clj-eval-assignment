(ns recsys.metric
  (:require [parenskit (vector :as lkv) (core :as lkc)])
  (:import [org.grouplens.lenskit.core LenskitRecommender]
           [org.grouplens.lenskit.eval.metrics TestUserMetricAccumulator]
           [org.grouplens.lenskit.eval.metrics.topn ItemSelectors]
           [org.grouplens.lenskit.eval.traintest TestUser]
           [recsys TagVocabulary]
           [recsys.dao ItemTagDAO]))

(defn tag-entropy
  "Return tag entropy for `n` recommendations for `user`."
  [n ^TestUser user]
  (if-let [recs (.getRecommendations
                 user n (ItemSelectors/allItems)
                 ,      (ItemSelectors/trainingItems))]
    (let [lkrec (.getRecommender user)
          tdao (lkc/rec-get lkrec ItemTagDAO)
          vocab (lkc/rec-get lkrec TagVocabulary)]
      ;; TODO implement the entropy metric and return the entropy
      0.0
      )))

(defn tag-entropy-accumulator
  "Return Clojure version of TagEntropyAccumulator."
  [n]
  (let [total-entropy (atom 0.0), user-count (atom 0)]
    (reify TestUserMetricAccumulator
      (evaluate [_ user]
        (let [entropy (tag-entropy n user)]
          (if (nil? entropy)
            (object-array 1)
            (do
              (swap! total-entropy + entropy)
              (swap! user-count inc)
              (object-array [entropy])))))

      (finalResults [_]
        (let [n @user-count, e (if (zero? n) Double/NaN (/ @total-entropy n))]
          (object-array [e]))))))
