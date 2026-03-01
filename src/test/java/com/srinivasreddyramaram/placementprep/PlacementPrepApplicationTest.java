package com.srinivasreddyramaram.placementprep;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "gemini.api.key=test-key")
class PlacementPrepApplicationTest {

    @Test
    void contextLoads() {
        // Verifies the Spring context starts up correctly
    }
}
