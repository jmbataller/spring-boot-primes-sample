package com.example.algorithms.filters;

import java.util.stream.LongStream;

/**
 * Is a number prime?
 * @author jmbataller
 */
public class PrimePredicate {

    public static boolean isPrime(final long num) {
        long numRoot = (long) Math.sqrt((double) num);
        return LongStream.rangeClosed(2, numRoot).noneMatch(i -> num % i == 0);
    }
}
