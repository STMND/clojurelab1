;Функция, возвращающая минимальный элемент внутри плавающего окна в бесконечной числовой последовательности

(defn find_min_in_seq []
  ;Создание последовательности рандомных чисел от 0 до 50
  (def rand_seq (repeatedly #(rand-int 50)))
  ;Вывод плавающего окна из последовательности, размерностью от 8 до 18
  (println (take (+ (rand-int 10) 8) rand_seq))
  ;Получение данного окна в отдельную переменную
  (def v (take (+ (rand-int 10) 8) rand_seq))
  ;Цикл получения минимального значения в окне
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

;Вызов функции
(println(find_min_in_seq))

