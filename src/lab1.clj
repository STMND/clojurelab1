
(def rand_seq (repeatedly #(rand-int 50)))
(print (take (+ (rand-int 5) 5) rand_seq))

