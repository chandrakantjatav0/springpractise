package com.blogapplication.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.helper.PostHelper;
import com.blogapplication.model.Post;
import com.blogapplication.repostitory.PostRepository;
import com.blogapplication.request.PostRequest;
import com.blogapplication.response.PostResponse;
import com.blogapplication.service.PostService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepo;

	@Autowired
	PostHelper postHelper;

	@Override
	public PostResponse addPost(PostRequest postRequest) throws ResourceNotFoundException {
		Post post = postHelper.postFromPostRequest(postRequest);
		postRepo.save(post);
		return postHelper.postResponseFromPost(post);
	}

	@Override
	public List<PostResponse> getAllPosts() {
		List<Post> list = postRepo.findAll();
		return list.stream().map(postHelper::postResponseFromPost).collect(Collectors.toList());
	}

	@Override
	public PostResponse getPostById(Integer postId) throws ResourceNotFoundException {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post not found With this Id"));
		return postHelper.postResponseFromPost(post);
	}

	@Override
	public String softDelete(Integer postId) throws ResourceNotFoundException {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post not found With this Id"));
		post.setDeleted(true);
		postRepo.save(post);
		return "softDeleted This Post as Archive";
	}

	@Override
	public String deletePost(Integer postId) throws ResourceNotFoundException {
	Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post not found With this Id"));
		postRepo.delete(post);;
		return "Post is Deleted Successfully..";
	}
}
