package com.example.integration;

import com.example.SpringBootPrimesSampleApplication;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.server.setup.MockMvcBuilders.webApplicationContextSetup;

/**
 * Abstract integration test that setups context
 * @author jmbataller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootPrimesSampleApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public abstract class AbstractIntegrationTest {

    protected static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger();

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Value("${local.server.port}")
    protected int port;

    protected String baseUrl;

    @Before
    public void setup() {
        this.mockMvc = webApplicationContextSetup(this.wac).build();
        baseUrl = "http://localhost:" + port;
    }
}
