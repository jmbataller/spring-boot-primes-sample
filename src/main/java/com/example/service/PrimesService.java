package com.example.service;

import com.example.algorithms.PrimesAlgorithm;

import java.util.List;

public interface PrimesService {

    List<Long> getPrimes(Long number, PrimesAlgorithm primesAlgorithm);
}
