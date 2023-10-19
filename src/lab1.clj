
(defn find_min_in_seq []
  (def rand_seq (repeatedly #(rand-int 50)))
  (println (take (+ (rand-int 10) 8) rand_seq))
  (def v (take (+ (rand-int 10) 8) rand_seq))
  (loop [shrinking (rest v)
         this-idx 1
         min-val (first v)
         min-idx 0]
    (if (empty? shrinking)
      {:val min-val :idx min-idx}
      (let [this-val (first shrinking)
            new-min? (< this-val min-val)]
        (recur (rest shrinking)
               (inc this-idx)
               (if new-min? this-val min-val)
               (if new-min? this-idx min-idx)
               )))))

(println(find_min_in_seq))

