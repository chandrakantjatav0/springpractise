package com.blogapplication.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
