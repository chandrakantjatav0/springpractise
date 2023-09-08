package com.blogapplication.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.model.Category;
import com.blogapplication.model.Comment;
import com.blogapplication.model.Post;
import com.blogapplication.model.User;
import com.blogapplication.repostitory.CategoryRepository;
import com.blogapplication.repostitory.CommentRepository;
import com.blogapplication.repostitory.PostRepository;
import com.blogapplication.repostitory.UserRepository;
import com.blogapplication.request.PostRequest;
import com.blogapplication.response.CommentResponse;
import com.blogapplication.response.PostResponse;

@Component
public class PostHelper {

	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	PostRepository postRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CommentRepository commentRepo;
	@Autowired
	CommentHelper commentHelper;

	public Post postFromPostRequest(PostRequest postRequest) throws ResourceNotFoundException {
		Post post = new Post();
		if (postRequest.getPostId() != null) {
			post = this.postRepo.findById(postRequest.getPostId())
					.orElseThrow(() -> new ResourceNotFoundException("no new Posts are available in your feed"));
		}
		post.setPostName(postRequest.getPostName());

		// category mapping
		Category category = categoryRepo.findById(postRequest.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category not Found with this Id"));
		post.setCategory(category);

		// User mapping
		User user = userRepo.findById(postRequest.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User  not Found with this Id"));
		post.setUser(user);

		// comment mapping;
		// Comment comment = commentRepo.findById(postRequest.getCommentIds()).o

		List<Integer> commentIds = postRequest.getCommentIds();
		List<Comment> comments = new ArrayList<>();
		for (Integer id : commentIds) {
			comments.add(commentRepo.findById(id).get());
		}
		post.setComments(comments);
		return post;
	}

	public PostResponse postResponseFromPost(Post post) {
		PostResponse postResponse = new PostResponse();
		postResponse.setPostId(post.getPostId());
		postResponse.setPostName(post.getPostName());
		postResponse.setDeleted(false);

		// category mapping
		postResponse.setCategoryId(post.getCategory().getCategoryId());
		postResponse.setPostType(post.getCategory().getPostType());

		// User mapping
		postResponse.setUserId(post.getUser().getUserId());
		postResponse.setUserName(post.getUser().getUserName());
		postResponse.setEmail(post.getUser().getEmail());

		// Comment Mapping
		List<Comment> comments = post.getComments();
		List<CommentResponse> commentResponses = comments.stream().map(commentHelper::commentResponseFromComment)
				.collect(Collectors.toList());
		postResponse.setCommentResponses(commentResponses);

		// return
		return postResponse;
	}
}
