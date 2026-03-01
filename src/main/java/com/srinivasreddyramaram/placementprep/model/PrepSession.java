package com.srinivasreddyramaram.placementprep.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * MODEL LAYER — "What does our data look like?"
 * -----------------------------------------------
 * Think of this like designing a table in Excel.
 * Each field here becomes a column in the database.
 * Each object of this class becomes one row.
 *
 * @Entity  → tells Spring: "store this in the database"
 * @Table   → names the table "prep_sessions"
 *
 * Lombok saves us from writing repetitive code:
 *   @Data             → auto-generates getters, setters, toString
 *   @NoArgsConstructor → auto-generates empty constructor (JPA needs this)
 *   @AllArgsConstructor → auto-generates constructor with all fields
 */
@Entity
@Table(name = "prep_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrepSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increments: 1, 2, 3...
    private Long id;

    @Column(nullable = false)
    private String topic;            // e.g. "Spring Boot" or "Arrays"

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questions;        // the 5 AI-generated questions (can be long)

    @Column(nullable = false)
    private LocalDateTime createdAt; // when this practice session was saved
}
