package com.example.algorithms;

import com.example.algorithms.filters.PrimePredicate;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

/**
 * Generate list of primes using an iterative approach (ideal for small numbers)
 * @author jmbataller
 */
public class PrimesRecursiveFunction implements Function<Long, List<Long>> {

    public PrimesRecursiveFunction() {}

    public static PrimesRecursiveFunction newInstance() {
        return new PrimesRecursiveFunction();
    }

    @Override
    public List<Long> apply(Long num) {
        return getPrimes(2L, num, Collections.emptyList());
    }

    private List<Long> getPrimes(Long from, Long to, List<Long> primes) {

        if(to <= 1 || to < from) {
            return Collections.emptyList();
        }

        if(PrimePredicate.isPrime(from)) {
            primes.add(from);
            primes.addAll(getPrimes(from + 1, to, primes));
            return primes;
        } else {
            return getPrimes(from + 1, to, primes);
        }
    }
}
