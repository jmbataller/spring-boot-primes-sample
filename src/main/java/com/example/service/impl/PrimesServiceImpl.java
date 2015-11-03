package com.example.service.impl;

import com.example.algorithms.PrimesAlgorithm;
import com.example.service.PrimesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimesServiceImpl implements PrimesService {

    @Override
    public List<Long> getPrimes(Long num, PrimesAlgorithm algorithm) {
        //return PrimesAlgorithm.BasicParallelIterative.function().apply(num);
        return algorithm.function().apply(num);
    }

}
