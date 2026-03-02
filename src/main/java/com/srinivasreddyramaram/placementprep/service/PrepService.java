package com.srinivasreddyramaram.placementprep.service;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import com.srinivasreddyramaram.placementprep.repository.PrepSessionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PrepService {

    private final PrepSessionRepository repository;
    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    public PrepService(PrepSessionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public PrepSession generateQuestions(String topic) {
        String prompt = "Generate exactly 5 interview questions for a fresher on the topic: " + topic
                + ". Number them 1 to 5. Keep them concise and relevant for campus placements.";

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        String url = apiUrl + "?key=" + apiKey;
        Map response = restTemplate.postForObject(url, requestBody, Map.class);
        String questions = extractQuestions(response);

        PrepSession session = new PrepSession();
        session.setTopic(topic);
        session.setQuestions(questions);
        session.setCreatedAt(LocalDateTime.now());

        return repository.save(session);
    }

    public List<PrepSession> getHistory() {
        return repository.findAll();
    }

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
