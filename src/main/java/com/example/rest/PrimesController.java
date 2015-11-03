package com.example.rest;

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
    public PrimesResponse findParticipants(
            @PathVariable(PARAM_INITIAL) long initial,
            @RequestParam(value = PARAM_ALGORITHM, required = false) String algorithm) {
        LOGGER.info("calculating primes for " + initial);
        List<Long> primes = primesService.getPrimes(initial);
        return PrimesResponse.create(initial, primes);
    }
}
