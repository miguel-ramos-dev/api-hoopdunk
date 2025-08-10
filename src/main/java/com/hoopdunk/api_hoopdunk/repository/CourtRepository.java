package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Long> {
}
