package com.example.algorithms;

import com.example.algorithms.filters.PrimePredicate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

/**
 * Generate list of primes using an iterative approach and several threads in parallel.
 * Also, caches the previous calculations and gets from a memory cache the already
 * calculated primes (ideal for big numbers)
 * @author jmbataller
 */
public class PrimesCachedIterativeFunction implements Function<Long, List<Long>> {

    private ConcurrentHashMap<Long, List<Long>> cache;

    private PrimesCachedIterativeFunction() {
        cache = new ConcurrentHashMap<>();
    }

    public static PrimesCachedIterativeFunction newInstance() {
        return new PrimesCachedIterativeFunction();
    }

    @Override
    public List<Long> apply(Long num) {

        if (Optional.ofNullable(cache.get(num)).isPresent() == false) {
            List<Long> primes = LongStream.rangeClosed(2, num)
                    .parallel()
                    .filter(PrimePredicate::isPrime)
                    .boxed()
                    .collect(toList());
            cache.put(num, primes);
        }

        return cache.get(num);
    }
}
