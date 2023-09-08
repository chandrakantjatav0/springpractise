package com.blogapplication.service;

import java.util.List;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.CommentRequest;
import com.blogapplication.response.CommentResponse;

public interface CommentService {
	CommentResponse addComment(CommentRequest commentRequest) throws ResourceNotFoundException;

  List<CommentResponse> getAllComments();

	CommentResponse getCommentById(Integer coomentId) throws ResourceNotFoundException;

	String softDeleteComment(Integer deleteId) throws ResourceNotFoundException;

	String deleteComment(Integer deleteId) throws ResourceNotFoundException;

}
