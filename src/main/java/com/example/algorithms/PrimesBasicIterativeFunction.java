package com.example.algorithms;

import com.example.algorithms.filters.PrimePredicate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

/**
 * Generate list of primes using an iterative approach (ideal for small numbers)
 * @author jmbataller
 */
public class PrimesBasicIterativeFunction implements Function<Long, List<Long>> {

    private PrimesBasicIterativeFunction() {}

    public static PrimesBasicIterativeFunction newInstance() {
        return new PrimesBasicIterativeFunction();
    }

    @Override
    public List<Long> apply(Long num) {
        return LongStream.rangeClosed(2, num)
                .filter(PrimePredicate::isPrime)
                .boxed()
                .collect(toList());
    }
}
