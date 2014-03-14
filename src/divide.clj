;Divides any two numbers upto termination or upto given decimal places - whatever happens first
(defn divide [numerator denominator acc]
  (defn divide-loop
    ([num den] (divide-loop num den 0 []))
    ([num den iter result-set]
      (let
        [qnt (quot num den)
         next_num (* (- num (* den qnt)) 10)
         current_iter (inc iter)
         current_results (if (= 0 iter) (conj (conj result-set qnt) ".") (conj result-set qnt))
         ]
        (if (or (> current_iter acc) (= next_num 0))
          (clojure.string/join "" current_results)
          (recur next_num den current_iter current_results)
        )
      )
    )
  )
  (divide-loop numerator denominator)
)

