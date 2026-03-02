package com.srinivasreddyramaram.placementprep.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "prep_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrepSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topic;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questions;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
