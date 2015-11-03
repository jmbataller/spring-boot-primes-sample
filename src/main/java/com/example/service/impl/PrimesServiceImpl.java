package com.example.service.impl;

import com.example.service.PrimesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@Service
public class PrimesServiceImpl implements PrimesService {

    @Override
    public List<Long> getPrimes(long num) {
        return LongStream.range(2, num + 1)
                .filter(this::isPrime)
                .boxed()
                .collect(toList());
    }

    public boolean isPrime(final long num) {
        return LongStream.range(2, num).noneMatch(i -> num % i == 0);
    }

    public boolean isPrime2(final long num) {
        long numRoot = (long) Math.sqrt((double) num);
        return LongStream.range(2, numRoot).noneMatch(i -> num % i == 0);
    }
}
