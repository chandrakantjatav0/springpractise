package com.libraryapplication.mapper;

import com.libraryapplication.dto.BookDto;
import com.libraryapplication.model.Book;

public class BookMapper {

	// Convert Book JPA Entity into UserDto
	public static BookDto mapToBookDto(Book book) {
		BookDto bookDto = new BookDto(book.getBookId(), book.getBookName(),book.isDeleted());
		return bookDto;

	} // Convert BookDto into User JPA Entity

	public static Book mapToBook(BookDto bookDto){
		Book book = new Book(bookDto.getBookId(), bookDto.getBookName(),bookDto.isDeleted());
		return book;
	}

}
