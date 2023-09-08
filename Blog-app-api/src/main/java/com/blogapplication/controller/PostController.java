package com.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.request.PostRequest;
import com.blogapplication.response.PostResponse;
import com.blogapplication.service.Impl.PostServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blogApp/post")
public class PostController {
	@Autowired
	private PostServiceImpl postService;

	@PostMapping("/save")
	public ResponseEntity<PostResponse> addPost(@RequestBody PostRequest postRequest) throws ResourceNotFoundException {
		return new ResponseEntity<>(postService.addPost(postRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<PostResponse> getAllPosts() {
		return postService.getAllPosts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostResponse> getPostById(@PathVariable("id") Integer postId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDelete(@PathVariable("id") Integer postId) throws ResourceNotFoundException {
		return new ResponseEntity<>(postService.softDelete(postId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") Integer postId) throws ResourceNotFoundException {
		return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
	}

}
