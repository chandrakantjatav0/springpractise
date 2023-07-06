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

import com.libraryapplication.dto.BookDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.service.impl.BookServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {
	private BookServiceImpl bookService;

	// Build Create a REST API
	// http://localhost:8080/api/book/save
	@PostMapping("/save")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
	}

//___________________________________________________________________________	
	// Build get all Book REST Api
	// http://localhost:8080/api/book/mapp
	@GetMapping("/getAll")
	public ResponseEntity<List<BookDto>> getAllBook() {
		List<BookDto> book = bookService.getAllBook();
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

//___________________________________________________________________________	
//Build get all book by Id REST Api
//http://localhost:8080/api/book/2
	@GetMapping("{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") Integer bookId) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
	}

//________________________________________________________________________________
//Build Update Book REST Api
//http://localhost:8080/api/book/1
//	@PutMapping("{id}")
//	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto, @PathVariable("id") Integer bookId)
//			throws ResourceNotFoundException {
//		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
//	}

//Build Soft Delete RestApi
	// http://localhost:8080/api/book/softDelete/3
	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteBook(@PathVariable("id") Integer bookId) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookService.softDeleteBook(bookId), HttpStatus.OK);
	}

//_______________________________________________________________________________________
//Build Delete BookById RestApi 
//http://localhost:8080/api/book/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
	}
}
