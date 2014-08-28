;Infinite lazy-prime sequence

(defn prime-seq[]

  (defn next-prime [n]
    (if (some #(= (mod n %1) 0) (range 2 (inc(Math/sqrt n))))
      (recur (inc n))
      (cons n (lazy-seq (next-prime (inc n))))
      )
    )
  (cons 2 (lazy-seq (next-prime 3)))
  )

