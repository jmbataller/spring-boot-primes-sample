package com.example.rest;

import com.example.algorithms.PrimesAlgorithm;
import com.example.domain.PrimesResponse;
import com.example.service.PrimesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import static com.example.rest.RestConstants.*;

public class PrimesControllerTest {

    @InjectMocks
    private PrimesController primesController;

    @Mock
    private PrimesService primesService;

    @Before
    public void init() {
        primesController = new PrimesController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void primesFor10WithBasicAlgo() {
        reset(primesService);
        when(primesService.getPrimes(anyLong(), any(PrimesAlgorithm.class))).thenReturn(Arrays.asList(2L, 3L, 5L, 7L));
        PrimesResponse resp = primesController.getPrimes(10L, ALGORITHM_BASIC_ITER);
        assertEquals(resp.getInitial().longValue(), 10L);
        assertTrue(resp.getPrimes().contains(2L));
        assertTrue(resp.getPrimes().contains(3L));
        assertTrue(resp.getPrimes().contains(5L));
        assertTrue(resp.getPrimes().contains(7L));
    }

    @Test
    public void primesFor10WithBasicParallelAlgo() {
        reset(primesService);
        when(primesService.getPrimes(anyLong(), any(PrimesAlgorithm.class))).thenReturn(Arrays.asList(2L, 3L, 5L, 7L));
        PrimesResponse resp = primesController.getPrimes(10L, ALGORITHM_BASIC_PARAL_ITER);
        assertEquals(resp.getInitial().longValue(), 10L);
        assertTrue(resp.getPrimes().contains(2L));
        assertTrue(resp.getPrimes().contains(3L));
        assertTrue(resp.getPrimes().contains(5L));
        assertTrue(resp.getPrimes().contains(7L));
    }

    @Test
    public void primesFor0WithBasicAlgo() {
        reset(primesService);
        when(primesService.getPrimes(anyLong(), any(PrimesAlgorithm.class))).thenReturn(Collections.emptyList());
        PrimesResponse resp = primesController.getPrimes(0L, ALGORITHM_BASIC_ITER);
        assertEquals(resp.getInitial().longValue(), 0);
        assertTrue(resp.getPrimes().isEmpty());
    }

    @Test
    public void primesForNegativeNumberWithBasicAlgo() {
        reset(primesService);
        when(primesService.getPrimes(anyLong(), any(PrimesAlgorithm.class))).thenReturn(Collections.emptyList());
        PrimesResponse resp = primesController.getPrimes(-5L, ALGORITHM_BASIC_ITER);
        assertEquals(resp.getInitial().longValue(), -5);
        assertTrue(resp.getPrimes().isEmpty());
    }
}
