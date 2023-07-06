package com.libraryapplication.service;

import java.util.List;

import com.libraryapplication.dto.LibrarianDto;
import com.libraryapplication.exception.ResourceNotFoundException;

public interface LibrarianSevice {

	LibrarianDto createLibrarian(LibrarianDto librarianDto) throws ResourceNotFoundException;

	List<LibrarianDto> getAllLibrarian();

	LibrarianDto getLibrarianById(Integer id) throws ResourceNotFoundException;

	//LibrarianDto updateLibrarian(LibrarianDto librarianDto, Integer id) throws ResourceNotFoundException;

	String softDeleteLibrarian(Integer id) throws ResourceNotFoundException;

	String deleteLibrarian(Integer id) throws ResourceNotFoundException;;
}
