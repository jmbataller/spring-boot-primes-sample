package com.example.algorithms;

import java.util.List;
import java.util.function.Function;

/**
 * Available algorithms to generate primes for a number
 *
 * @author jmbataller
 */
public enum PrimesAlgorithm {

    BasicIterative(PrimesBasicIterativeFunction.newInstance()),
    BasicParallelIterative(PrimesBasicParallelIterativeFunction.newInstance());

    private Function<Long, List<Long>> function;

    private PrimesAlgorithm(Function<Long, List<Long>> function) {
        this.function = function;
    }

    public Function<Long, List<Long>> function() {
        return function;
    }

}
