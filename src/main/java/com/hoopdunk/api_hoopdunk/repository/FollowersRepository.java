package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.Followers;
import com.hoopdunk.api_hoopdunk.domain.PrimaryKeyFollowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, PrimaryKeyFollowers> {
}
