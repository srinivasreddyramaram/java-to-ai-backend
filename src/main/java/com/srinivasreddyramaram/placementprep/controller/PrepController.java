package com.srinivasreddyramaram.placementprep.controller;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import com.srinivasreddyramaram.placementprep.service.PrepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prep")
public class PrepController {

    private final PrepService prepService;

    public PrepController(PrepService prepService) {
        this.prepService = prepService;
    }

    @PostMapping
    public ResponseEntity<PrepSession> generateQuestions(@RequestParam String topic) {
        return ResponseEntity.ok(prepService.generateQuestions(topic));
    }

    @GetMapping("/history")
    public ResponseEntity<List<PrepSession>> getHistory() {
        return ResponseEntity.ok(prepService.getHistory());
    }
}
