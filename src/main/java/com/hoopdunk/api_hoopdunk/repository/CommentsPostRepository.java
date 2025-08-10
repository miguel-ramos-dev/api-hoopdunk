package com.hoopdunk.api_hoopdunk.repository;

import com.hoopdunk.api_hoopdunk.domain.CommentsPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsPostRepository extends JpaRepository<CommentsPost, Long> {
}
