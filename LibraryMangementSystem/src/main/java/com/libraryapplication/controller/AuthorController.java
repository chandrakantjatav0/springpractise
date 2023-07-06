package com.libraryapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapplication.dto.AuthorDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.service.impl.AuthorServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorController {
	private AuthorServiceImpl authorService;

// Build Create author REST API
// http://localhost:8080/api/author/save
	@PostMapping("/save")
	public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) throws ResourceNotFoundException {
		return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
	}

// Build get all Author REST Api
// http://localhost:8080/api/author/getAllAuthor
	@GetMapping("/getAll")
	public ResponseEntity<List<AuthorDto>> getAllAuthor() {
		List<AuthorDto> author = authorService.getAllAuthor();
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

// Build getbyid  Author REST Api
// http://localhost:8080/api/author/4
	@GetMapping("{id}")
	public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Integer authorId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
	}
//		

// Build author  update by id  REST Api
// http://localhost:8080/api/author/2
//	@PutMapping("{id}")
//	public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable Integer authorId)
//			throws ResourceNotFoundException {
//		return new ResponseEntity<>(authorService.updateAuthor(authorDto, authorId), HttpStatus.OK);
//	}

	// Build Author softDelete RestApi
	// http://localhost:8080/api/author/softDelete/3
	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteAuthor(@PathVariable("id") Integer authorId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(authorService.softDeleteAuthor(authorId), HttpStatus.OK);

	}

// Build author  delete by id  REST Api
// http://localhost:8080/api/author/5
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("id") Integer authorId) throws ResourceNotFoundException {
		return new ResponseEntity<>(authorService.deleteAuthor(authorId), HttpStatus.OK);
	}
}
