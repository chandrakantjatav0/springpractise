package com.libraryapplication.mapper;

import com.libraryapplication.dto.LibrarianDto;
import com.libraryapplication.model.Librarian;

public class LibrarianMapper {
	// Convert Librarian JPA Entity into UserDto
	public static LibrarianDto mapToLibrarianDto(Librarian librarian) {
		LibrarianDto librarianDto = new LibrarianDto(librarian.getLibrarianId(), librarian.getLibrarianName(),
				librarian.isDeleted());
		return librarianDto;
	}

	// Convert LibrarianDto into User JPA Entity
	public static Librarian mapTolibrarian(LibrarianDto librarianDto) {
		Librarian librarian = new Librarian(librarianDto.getLibrarianId(), librarianDto.getLibrarianName(),
				librarianDto.isDeleted());
		return librarian;
	}
}
