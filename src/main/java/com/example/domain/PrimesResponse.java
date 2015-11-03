package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class PrimesResponse {

    @XmlAttribute
    @JsonProperty(value = "Initial")
    private Long initial;

    @XmlAttribute
    @JsonProperty(value = "Priimes")
    private List<Long> primes;

    public PrimesResponse() {}

    private PrimesResponse(final Long initial, final List<Long> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public static PrimesResponse create(final Long initial, final List<Long> primes) {
        return new PrimesResponse(initial, primes);
    }

    public Long getInitial() {
        return initial;
    }

    public List<Long> getPrimes() {
        return primes;
    }
}
