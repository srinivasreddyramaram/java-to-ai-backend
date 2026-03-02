package com.srinivasreddyramaram.placementprep.repository;

import com.srinivasreddyramaram.placementprep.model.PrepSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepSessionRepository extends JpaRepository<PrepSession, Long> {
}
