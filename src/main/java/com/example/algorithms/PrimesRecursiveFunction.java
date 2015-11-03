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

        if(to < from) {
            return primes;
        }

        if(to % from == 0) {
            primes.addAll(getPrimes(to / from, from, primes));
            factors.add(from);
            return factors;
        } else {
            return getPrimes(from + 1, to, primes);
        }
    }
}
