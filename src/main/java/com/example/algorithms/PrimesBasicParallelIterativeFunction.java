package com.example.algorithms;

import com.example.algorithms.filters.PrimePredicate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

/**
 * Generate list of primes using an iterative approach and multi-threading (ideal for big numbers)
 * @author jmbataller
 */
public class PrimesBasicParallelIterativeFunction implements Function<Long, List<Long>> {

    private PrimesBasicParallelIterativeFunction() {}

    public static PrimesBasicParallelIterativeFunction newInstance() {
        return new PrimesBasicParallelIterativeFunction();
    }

    @Override
    public List<Long> apply(Long num) {
        return LongStream.rangeClosed(2, num)
                .parallel()
                .filter(PrimePredicate::isPrime)
                .boxed()
                .collect(toList());
    }
}
