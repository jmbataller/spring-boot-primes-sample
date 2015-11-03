package com.example.integration;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MvcResult;

import static com.example.rest.RestConstants.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

public class PrimesIntegrationTest extends AbstractIntegrationTest {

    private final String INITIAL = "Initial";
    private final String PRIMES = "Priimes";

    @Test
    public void primesFor10InOrder() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(10))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES + "[0]").value(2))
                .andExpect(jsonPath("$." + PRIMES + "[1]").value(3))
                .andExpect(jsonPath("$." + PRIMES + "[2]").value(5))
                .andExpect(jsonPath("$." + PRIMES + "[3]").value(7))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void primesFor5Included() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(5))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES + "[2]").value(5))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void primesForNegativeNum() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/-10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(-10))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES, hasSize(0)))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void invalidNumber() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/xxx")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void primesFor10InOrderWithBasicAlgo() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/10")
                .param(PARAM_ALGORITHM, ALGORITHM_BASIC_ITER)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(10))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES + "[0]").value(2))
                .andExpect(jsonPath("$." + PRIMES + "[1]").value(3))
                .andExpect(jsonPath("$." + PRIMES + "[2]").value(5))
                .andExpect(jsonPath("$." + PRIMES + "[3]").value(7))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void primesFor5WithParallelAlgo() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/5")
                .param(PARAM_ALGORITHM, ALGORITHM_BASIC_PARAL_ITER)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(5))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES + "[2]").value(5))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }

    @Test
    public void primesFor5WithParallelAndCacheAlgo() throws Exception {

        MvcResult result = mockMvc.perform(get(PRIMES_ENDPOINT + "/5")
                .param(PARAM_ALGORITHM, ALGORITHM_CACHED_PARAL_ITER)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$." + INITIAL).value(5))
                .andExpect(jsonPath("$." + PRIMES).isArray())
                .andExpect(jsonPath("$." + PRIMES + "[2]").value(5))
                .andReturn();

        LOGGER.info(result.getResponse().getContentAsString());
    }
}
