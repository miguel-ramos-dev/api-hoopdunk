package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.EventPlayers;
import com.hoopdunk.api_hoopdunk.domain.EventPlayersPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPlayersRepository extends JpaRepository<EventPlayers ,EventPlayersPrimaryKey> {
}
