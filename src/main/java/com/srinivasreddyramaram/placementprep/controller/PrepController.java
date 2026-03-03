package com.srinivasreddyramaram.placementprep.controller;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import com.srinivasreddyramaram.placementprep.service.PrepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CONTROLLER LAYER — "Handle HTTP requests"
 * -------------------------------------------
 * The controller is the front door of your app.
 * It receives requests from the browser or Postman,
 * hands the work to the Service, and sends back a response.
 *
 * ONE RULE: the controller does NO business logic.
 * It only receives, delegates, and responds.
 *
 * @RestController → this class handles HTTP and returns JSON
 * @RequestMapping → all endpoints here start with /prep
 */
@RestController
@RequestMapping("/prep")
public class PrepController {

    // Spring automatically injects PrepService here (Dependency Injection)
    private final PrepService prepService;

    public PrepController(PrepService prepService) {
        this.prepService = prepService;
    }

    /**
     * POST /prep?topic=Spring Boot
     *
     * Called when a student submits a topic.
     * @RequestParam reads the "topic" value from the URL query string.
     *
     * Try it: POST http://localhost:8080/prep?topic=Arrays
     */
    @PostMapping
    public ResponseEntity<PrepSession> generateQuestions(@RequestParam String topic) {
        // TODO: What happens if someone sends an empty topic?
        // Try: POST http://localhost:8080/prep?topic=
        // Then uncomment the block below and see the difference.
//        if (topic == null || topic.isBlank()) {
//            return ResponseEntity.badRequest().body("Topic cannot be empty");
//        }
        PrepSession session = prepService.generateQuestions(topic);
        return ResponseEntity.ok(session);
    }

    /**
     * GET /prep/history
     *
     * Returns every practice session saved so far.
     * Try it: GET http://localhost:8080/prep/history
     */
    @GetMapping("/history")
    public ResponseEntity<List<PrepSession>> getHistory() {
        List<PrepSession> history = prepService.getHistory();
        return ResponseEntity.ok(history);
    }
}
