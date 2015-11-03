package com.example.integration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MvcResult;

import java.util.List;
import java.util.Map;

import static com.example.rest.RestConstants.PRIMES_ENDPOINT;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

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
}
