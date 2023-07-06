package com.libraryapplication.service;

import java.util.List;

import com.libraryapplication.dto.BookDto;
import com.libraryapplication.exception.ResourceNotFoundException;

public interface BookService {

	BookDto createBook(BookDto bookDto) throws ResourceNotFoundException;

	List<BookDto> getAllBook();

	BookDto getBookById(Integer id) throws ResourceNotFoundException;

	//BookDto updateBook(BookDto bookDto, Integer id) throws ResourceNotFoundException;

	String softDeleteBook(Integer id) throws ResourceNotFoundException;

	String deleteBook(Integer id) throws ResourceNotFoundException;

}