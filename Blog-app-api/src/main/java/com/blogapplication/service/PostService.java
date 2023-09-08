package com.blogapplication.service;

import java.util.List;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.PostRequest;
import com.blogapplication.response.PostResponse;

public interface PostService {
	PostResponse addPost(PostRequest postRequest) throws ResourceNotFoundException;

	List<PostResponse> getAllPosts();

	PostResponse getPostById(Integer postId) throws ResourceNotFoundException;

	String softDelete(Integer postId) throws ResourceNotFoundException;

	String deletePost(Integer postId) throws ResourceNotFoundException;

}