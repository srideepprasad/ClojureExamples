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
          (recur (remove #(= (mod %1 next-prime) 0) numbers) (conj current-prime-set next-prime))
      ))))
  (filter-non-primes (range 2 n))
  )










