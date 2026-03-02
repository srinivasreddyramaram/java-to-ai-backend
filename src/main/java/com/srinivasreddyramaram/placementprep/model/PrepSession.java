package com.srinivasreddyramaram.placementprep.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * MODEL LAYER — "What does our data look like?"
 * -----------------------------------------------
 * Think of this like designing a table in Excel.
 * Each field here becomes a column in the database.
 * Each object of this class becomes one row.
 *
 * @Entity → tells Spring: "store this in the database"
 * @Table  → names the database table "prep_sessions"
 */
@Entity
@Table(name = "prep_sessions")
public class PrepSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increments: 1, 2, 3...
    private Long id;

    @Column(nullable = false)
    private String topic;            // e.g. "Spring Boot" or "Arrays"

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questions;        // the 5 AI-generated questions

    @Column(nullable = false)
    private LocalDateTime createdAt; // when this session was saved

    // -------------------------------------------------------
    // Constructors
    // -------------------------------------------------------

    public PrepSession() {
        // JPA requires an empty constructor
    }

    // -------------------------------------------------------
    // Getters — used to READ each field
    // -------------------------------------------------------

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getQuestions() {
        return questions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // -------------------------------------------------------
    // Setters — used to SET each field
    // -------------------------------------------------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
