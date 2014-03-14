; Tests whether the given number is prime or not
(defn prime? [n] (not-any? #(= (mod n %1) 0) (range 2 (Math/sqrt n))))


;Returns a set of prime numbers within the given range. Makes use of the Prime Sieve Method
(defn primes [m n]
  (defn filter-non-primes
    ([numbers] (filter-non-primes numbers #{}))
    ([numbers current-prime-set]
      (let
        [next-prime (first numbers)]
        (if (empty? numbers)
          (filter #(> %1 m) current-prime-set)
          (recur (doall (remove #(= (mod %1 next-prime) 0) numbers)) (conj current-prime-set next-prime))
      ))))
  (filter-non-primes (range 2 n))
  )


;Returns a set of prime numbers within the given range. Makes use of the Prime Sieve Method
(defn pprimes [m n]

  (defn filter-multiples [ numbers divisor]
    (
      remove #(= (mod %1 divisor) 0) numbers
    )
  )
  (defn filter-multiples-async[numbers divisor threads]
    (let
      [partitions (partition-all (/ (count numbers) threads) numbers)]
      (
        flatten (map #(future (filter-multiples %1 divisor))  partitions)
      )
    )
  )
  (defn filter-non-primes
    ([numbers] (filter-non-primes numbers #{}))
    ([numbers current-prime-set]
      (let
        [next-prime (first numbers)]
        (if (empty? numbers)
          (filter #(> %1 m) current-prime-set)
;          (println (map #( deref %1) (filter-multiples-async numbers next-prime 10)))
          (recur (doall(flatten (map #( deref %1) (filter-multiples-async numbers next-prime 10)))) (conj current-prime-set next-prime))
        )
      )
    )
  )
  (filter-non-primes (range 2 n))
)










