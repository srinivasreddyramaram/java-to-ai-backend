package com.srinivasreddyramaram.placementprep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * CONFIG LAYER — "Set up shared tools"
 * --------------------------------------
 * @Configuration tells Spring: "this class creates shared objects."
 *
 * @Bean tells Spring: "create this object once and share it
 * with anyone in the app who needs it." This is called
 * Dependency Injection — one of the most important patterns
 * in professional Java development.
 *
 * RestTemplate is Spring's built-in HTTP client.
 * We use it to make HTTP calls to the Gemini AI API —
 * the same way your browser makes calls to a server.
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
