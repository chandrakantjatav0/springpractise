package com.blogapplication.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.helper.CommentHelper;
import com.blogapplication.model.Comment;
import com.blogapplication.repostitory.CommentRepository;
import com.blogapplication.request.CommentRequest;
import com.blogapplication.response.CommentResponse;
import com.blogapplication.service.CommentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private CommentHelper commentHelper;

	@Override
	public CommentResponse addComment(CommentRequest commentRequest) throws ResourceNotFoundException {
		Comment comment = commentHelper.commentFromCommentRequest(commentRequest);
		commentRepo.save(comment);
		return commentHelper.commentResponseFromComment(comment);
	}

	@Override
	public List<CommentResponse> getAllComments() {
		List<Comment> list = commentRepo.findAll();
		return list.stream().map(commentHelper::commentResponseFromComment).collect(Collectors.toList());
	}

	@Override
	public CommentResponse getCommentById(Integer coomentId) throws ResourceNotFoundException {
		Comment comment = commentRepo.findById(coomentId)
				.orElseThrow(() -> new ResourceNotFoundException("Commenter not Found"));
		return commentHelper.commentResponseFromComment(comment);
	}

	@Override
	public String softDeleteComment(Integer deleteId) throws ResourceNotFoundException {
		Comment comment = commentRepo.findById(deleteId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not Found"));
		comment.setDeleted(true);
		commentRepo.save(comment);
		return "Soft deleted  this Comment..";
	}

	@Override
	public String deleteComment(Integer deleteId) throws ResourceNotFoundException {
		Comment comment = commentRepo.findById(deleteId).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
		commentRepo.delete(comment);
		return "Comment is deleted";
	}
}
