package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
