package com.example.service;

import com.example.algorithms.PrimesAlgorithm;
import com.example.service.impl.PrimesServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class PrimesServiceTest {

    @InjectMocks
    private PrimesService primesService;

    @Before
    public void init() {
        primesService = new PrimesServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void primesFor20() {
        List<Long> primes = primesService.getPrimes(20L, PrimesAlgorithm.BasicIterative);
        assertTrue(primes.contains(2L));
        assertTrue(primes.contains(3L));
        assertTrue(primes.contains(5L));
        assertTrue(primes.contains(7L));
        assertTrue(primes.contains(11L));
        assertTrue(primes.contains(13L));
        assertTrue(primes.contains(19L));
    }

    @Test
    public void primesFor20ParallelAlgo() {
        List<Long> primes = primesService.getPrimes(20L, PrimesAlgorithm.BasicParallelIterative);
        assertTrue(primes.contains(2L));
        assertTrue(primes.contains(3L));
        assertTrue(primes.contains(5L));
        assertTrue(primes.contains(7L));
        assertTrue(primes.contains(11L));
        assertTrue(primes.contains(13L));
        assertTrue(primes.contains(19L));
    }

    @Ignore
    @Test
    public void primesFor20RecursiveAlgo() {
        List<Long> primes = primesService.getPrimes(20L, PrimesAlgorithm.BasicRecursive);
        assertTrue(primes.contains(2L));
        assertTrue(primes.contains(3L));
        assertTrue(primes.contains(5L));
        assertTrue(primes.contains(7L));
        assertTrue(primes.contains(11L));
        assertTrue(primes.contains(13L));
        assertTrue(primes.contains(19L));
    }
}
