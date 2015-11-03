package com.example.service;

import com.example.algorithms.PrimesAlgorithm;
import com.example.service.impl.PrimesServiceImpl;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class PrimesServiceTest {

    protected static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger();

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

    @Test
    public void primesFor20CachedParallelAlgo() {
        List<Long> primes = primesService.getPrimes(20L, PrimesAlgorithm.CachedParallelIterative);
        assertTrue(primes.contains(2L));
        assertTrue(primes.contains(3L));
        assertTrue(primes.contains(5L));
        assertTrue(primes.contains(7L));
        assertTrue(primes.contains(11L));
        assertTrue(primes.contains(13L));
        assertTrue(primes.contains(17L));
        assertTrue(primes.contains(19L));
    }

    /**
     * Checks that 2nd call using cache is faster than 1st call
     */
    @Test
    public void cacheIsFaster() {
        long firstIni = System.currentTimeMillis();
        List<Long> primes = primesService.getPrimes(20L, PrimesAlgorithm.CachedParallelIterative);
        long firstTime = System.currentTimeMillis() - firstIni;

        long secondIni = System.currentTimeMillis();
        primes = primesService.getPrimes(20L, PrimesAlgorithm.CachedParallelIterative);
        long secondTime = System.currentTimeMillis() - secondIni;

        LOGGER.info(firstTime + " vs " + secondTime);
        assertTrue(secondTime < firstTime);
    }

    /**
     * Checks that 2nd call using cache is faster than 1st call
     */
    @Test
    public void parallelIsFaster() {
        long firstIni = System.currentTimeMillis();
        List<Long> primes = primesService.getPrimes(100000L, PrimesAlgorithm.BasicIterative);
        long firstTime = System.currentTimeMillis() - firstIni;

        long secondIni = System.currentTimeMillis();
        primes = primesService.getPrimes(100000L, PrimesAlgorithm.BasicParallelIterative);
        long secondTime = System.currentTimeMillis() - secondIni;

        LOGGER.info(firstTime + " vs " + secondTime);
        assertTrue(secondTime < firstTime);
    }

    /**
     * Checks that 2nd call using cache is faster than 1st call
     */
    @Test
    public void parallelIsFasterEvenIfRunFirst() {
        long firstIni = System.currentTimeMillis();
        List<Long> primes = primesService.getPrimes(5000000L, PrimesAlgorithm.BasicParallelIterative);
        long firstTime = System.currentTimeMillis() - firstIni;

        long secondIni = System.currentTimeMillis();
        primes = primesService.getPrimes(5000000L, PrimesAlgorithm.BasicIterative);
        long secondTime = System.currentTimeMillis() - secondIni;

        LOGGER.info(firstTime + " vs " + secondTime);
        assertTrue(secondTime > firstTime);
    }

    @Test
    public void parallelIsWorseForSmallNums() {
        long firstIni = System.currentTimeMillis();
        List<Long> primes = primesService.getPrimes(10L, PrimesAlgorithm.BasicParallelIterative);
        long firstTime = System.currentTimeMillis() - firstIni;

        long secondIni = System.currentTimeMillis();
        primes = primesService.getPrimes(10L, PrimesAlgorithm.BasicIterative);
        long secondTime = System.currentTimeMillis() - secondIni;

        LOGGER.info(firstTime + " vs " + secondTime);
        assertTrue(secondTime < firstTime);
    }

}
