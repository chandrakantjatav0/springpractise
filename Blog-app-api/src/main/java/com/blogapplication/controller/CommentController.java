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
import com.blogapplication.request.CommentRequest;
import com.blogapplication.response.CommentResponse;
import com.blogapplication.service.Impl.CommentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blogApp/comment")
public class CommentController {

	@Autowired 
	private CommentServiceImpl commentService;

	@PostMapping("/save")
	public ResponseEntity<CommentResponse> addComment(@RequestBody CommentRequest commentRequest)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(commentService.addComment(commentRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<CommentResponse> getAllComments() {
		return commentService.getAllComments();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommentResponse> getCommentById(@PathVariable("id") Integer coomentId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(commentService.getCommentById(coomentId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteComment(@PathVariable("id") Integer deleteId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(commentService.softDeleteComment(deleteId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Integer deleteId) throws ResourceNotFoundException {
		return new ResponseEntity<>(commentService.deleteComment(deleteId), HttpStatus.OK);
	}
}
