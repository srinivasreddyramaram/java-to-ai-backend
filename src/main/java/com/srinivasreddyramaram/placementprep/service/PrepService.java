package com.srinivasreddyramaram.placementprep.service;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import com.srinivasreddyramaram.placementprep.repository.PrepSessionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * SERVICE LAYER — "All the business logic"
 * ------------------------------------------
 * The service is the brain of your app.
 * It decides WHAT to do — call the AI, save to the database,
 * combine results. No HTTP, no SQL directly — just logic.
 *
 * Why keep this separate from the controller?
 * If you want to add a mobile app later, it uses the same
 * service — you just add a new controller. Zero duplication.
 *
 * @Service → tells Spring this class contains business logic
 * @Value   → reads values from application.properties
 */
@Service
public class PrepService {

    private final PrepSessionRepository repository;
    private final RestTemplate restTemplate;

    // These values are read from application.properties automatically
    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    // Spring injects both dependencies automatically
    public PrepService(PrepSessionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    /**
     * Generates 5 interview questions on the given topic using Gemini AI,
     * saves them to the database, and returns the saved session.
     *
     * Step-by-step flow:
     *   1. Build a prompt (what we ask the AI)
     *   2. Build the request body (JSON format Gemini expects)
     *   3. Call Gemini API over HTTP → get the response
     *   4. Extract the text from the response
     *   5. Save topic + questions to the database
     */
    public PrepSession generateQuestions(String topic) {

        // Step 1: Write the prompt — this is what we send to the AI
        String prompt = "Generate exactly 5 interview questions for a fresher on the topic: " + topic
                + ". Number them 1 to 5. Keep them concise and relevant for campus placements.";

        // Step 2: Gemini expects this specific JSON structure in the request body
        //   { "contents": [ { "parts": [ { "text": "..." } ] } ] }
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        // Step 3: Call Gemini — API key goes in the URL as a query param
        String url = apiUrl + "?key=" + apiKey;
        Map response = restTemplate.postForObject(url, requestBody, Map.class);

        // Step 4: Dig into the response JSON to get the generated text
        String questions = extractQuestions(response);

        // Step 5: Build a PrepSession object and save it to the database
        PrepSession session = new PrepSession();
        session.setTopic(topic);
        session.setQuestions(questions);
        session.setCreatedAt(LocalDateTime.now());

        return repository.save(session); // save() returns the saved object with its auto-generated id
    }

    /**
     * Returns the full history of all practice sessions from the database.
     */
    public List<PrepSession> getHistory() {
        return repository.findAll(); // SELECT * FROM prep_sessions
    }

    /**
     * Gemini returns a nested JSON structure. This helper navigates it
     * to extract just the generated text.
     *
     * Response shape:
     * {
     *   "candidates": [
     *     { "content": { "parts": [ { "text": "1. Question one\n2. ..." } ] } }
     *   ]
     * }
     */
    @SuppressWarnings("unchecked")
    private String extractQuestions(Map<?, ?> response) {
        List<?> candidates = (List<?>) response.get("candidates");
        Map<?, ?> first    = (Map<?, ?>) candidates.get(0);
        Map<?, ?> content  = (Map<?, ?>) first.get("content");
        List<?> parts      = (List<?>) content.get("parts");
        Map<?, ?> part     = (Map<?, ?>) parts.get(0);
        return (String) part.get("text");
    }
}
