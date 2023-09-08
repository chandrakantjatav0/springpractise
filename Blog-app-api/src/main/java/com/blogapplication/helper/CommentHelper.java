package com.blogapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.model.Comment;
import com.blogapplication.model.Post;
import com.blogapplication.model.User;
import com.blogapplication.repostitory.CommentRepository;
import com.blogapplication.repostitory.PostRepository;
import com.blogapplication.repostitory.UserRepository;
import com.blogapplication.request.CommentRequest;
import com.blogapplication.response.CommentResponse;

@Component
public class CommentHelper {
	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentRepository commentRepo;
	@Autowired
	UserRepository userRepo;

	public Comment commentFromCommentRequest(CommentRequest commentRequest) throws ResourceNotFoundException {
		Comment comment = new Comment();
		if (commentRequest.getCommentId() != null) {
			comment = this.commentRepo.findById(commentRequest.getCommentId())
					.orElseThrow(() -> new ResourceNotFoundException("No comments in the Post"));
		}
		comment.setComments(commentRequest.getComments());
		// Post mapping
		Post post = postRepo.findById(commentRequest.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Post Id not Found"));
		comment.setPost(post);
		// User mapping
		User user = userRepo.findById(commentRequest.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found With this Id"));
		comment.setUser(user);
		// return comment
		return comment;
	}

	public CommentResponse commentResponseFromComment(Comment comment) {
		CommentResponse commentResponse = new CommentResponse();
		commentResponse.setCommentId(comment.getCommentId());
		commentResponse.setComments(comment.getComments());
		commentResponse.setDeleted(false);
		// post mapping
		commentResponse.setPostId(comment.getPost().getPostId());
		commentResponse.setPostName(comment.getPost().getPostName());
		// user mapping
		commentResponse.setUserId(comment.getUser().getUserId());
		commentResponse.setUserName(comment.getUser().getUserName());
		commentResponse.setEmail(comment.getUser().getEmail());
		// return comment response
		return commentResponse;
	}
}
