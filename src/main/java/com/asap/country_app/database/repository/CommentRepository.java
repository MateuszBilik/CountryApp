package com.asap.country_app.database.repository;

import com.asap.country_app.database.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findCommentsByLocation_Id(UUID locationId);
}
