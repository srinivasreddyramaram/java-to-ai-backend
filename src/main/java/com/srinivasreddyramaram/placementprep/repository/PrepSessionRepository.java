package com.srinivasreddyramaram.placementprep.repository;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * REPOSITORY LAYER — "Talk to the database"
 * -------------------------------------------
 * This is where all database operations happen.
 * We extend JpaRepository and Spring gives us these methods for FREE:
 *
 *   save(session)   → INSERT a new row into the database
 *   findAll()       → SELECT * FROM prep_sessions
 *   findById(id)    → SELECT * WHERE id = ?
 *   deleteById(id)  → DELETE WHERE id = ?
 *   count()         → SELECT COUNT(*) FROM prep_sessions
 *
 * We write ZERO SQL. Spring generates it all automatically.
 * In a real company (Swiggy, Zomato), this would connect to PostgreSQL.
 * Here, it connects to H2 — same code, different database.
 */
@Repository
public interface PrepSessionRepository extends JpaRepository<PrepSession, Long> {
    // No code needed! JpaRepository already gives us save() and findAll().
}
