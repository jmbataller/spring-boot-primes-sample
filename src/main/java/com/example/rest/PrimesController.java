package com.example.rest;

import com.example.algorithms.PrimesAlgorithm;
import com.example.domain.PrimesResponse;
import com.example.service.PrimesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.rest.RestConstants.*;

@RestController
@RequestMapping(PRIMES_ENDPOINT)
public class PrimesController {

    private static final Logger LOGGER = LogManager.getLogger(PrimesController.class);

    @Autowired
    private PrimesService primesService;

    @RequestMapping(value = "/{" + PARAM_INITIAL + "}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public PrimesResponse getPrimes(
            @PathVariable(PARAM_INITIAL) Long initial,
            @RequestParam(value = PARAM_ALGORITHM, required = false, defaultValue = ALGORITHM_BASIC_ITER) String algorithm) {
        LOGGER.info("calculating primes for " + initial);
        List<Long> primes = primesService.getPrimes(initial, PrimesAlgorithm.valueOf(algorithm));
        return PrimesResponse.create(initial, primes);
    }
}
