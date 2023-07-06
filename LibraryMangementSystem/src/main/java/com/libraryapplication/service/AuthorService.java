package com.libraryapplication.service;

import java.util.List;

import com.libraryapplication.dto.AuthorDto;
import com.libraryapplication.exception.ResourceNotFoundException;

public interface AuthorService {
	AuthorDto createAuthor(AuthorDto authorDto) throws ResourceNotFoundException;

	List<AuthorDto> getAllAuthor();

	AuthorDto getAuthorById(Integer id) throws ResourceNotFoundException;

	//AuthorDto updateAuthor(AuthorDto authorDto, Integer id) throws ResourceNotFoundException;

	String softDeleteAuthor(Integer id) throws ResourceNotFoundException;

	String deleteAuthor(Integer id) throws ResourceNotFoundException;

}
