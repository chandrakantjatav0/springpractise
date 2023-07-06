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

import com.libraryapplication.dto.LibrarianDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.service.impl.LibrarianServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/librarian")
public class LibrarianController {
	private LibrarianServiceImpl librarianService;

	// Build Create a REST API
// http://localhost:8080/api/librarian/save
	@PostMapping("/save")
	public ResponseEntity<LibrarianDto> createLibrarian(@RequestBody LibrarianDto librarianDto)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(librarianService.createLibrarian(librarianDto), HttpStatus.CREATED);
	}

//____________________________________________________________________________________
//Build getAll Librarian REST Api 
//http://localhost:8080/api/librarian/mapp
	@GetMapping("/getAll")
	public ResponseEntity<List<LibrarianDto>> getAllLibrarian() {
		List<LibrarianDto> librarian = librarianService.getAllLibrarian();
		return new ResponseEntity<>(librarian, HttpStatus.OK);
	}

//______________________________________________________________________________________
//Build get all Librarian by Id REST Api
//http://localhost:8080/api/librarian/3	
	@GetMapping("{id}")
	public ResponseEntity<LibrarianDto> getLibrarianById(@PathVariable("id") Integer librarianId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(librarianService.getLibrarianById(librarianId), HttpStatus.OK);
	}

//_______________________________________________________________________________________
//Build Update LibrarianById REST Api
//http://localhost:8080/api/librarian/3	
//	@PutMapping("{id}")
//	public ResponseEntity<LibrarianDto> updateLibrarian(@RequestBody LibrarianDto librarianDto,
//			@PathVariable("id") Integer librarianId) throws ResourceNotFoundException {
//		return new ResponseEntity<>(librarianService.updateLibrarian(librarianDto, librarianId), HttpStatus.OK);
//	}

	// Buid Soft Delete Rest API
	// http://localhost:8080/api/librarian/softDelete/3
	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteLibrarian(@PathVariable("id") Integer librarianId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(librarianService.softDeleteLibrarian(librarianId), HttpStatus.OK);
	}

//_______________________________________________________________________________________
//Build Delete LibrarianById REST Api
//http://localhost:8080/api/librarian/2
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLibrarian(@PathVariable("id") Integer librarianId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(librarianService.deleteLibrarian(librarianId), HttpStatus.OK);
	}
}
