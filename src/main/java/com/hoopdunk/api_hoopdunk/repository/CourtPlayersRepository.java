package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.CourtPlayers;
import com.hoopdunk.api_hoopdunk.domain.CourtPlayersPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtPlayersRepository extends JpaRepository<CourtPlayers, CourtPlayersPrimaryKey> {
}
