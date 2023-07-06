package com.libraryapplication.mapper;

import com.libraryapplication.dto.AuthorDto;
import com.libraryapplication.model.Author;

public class AuthorMapper {
	// Convert Author JPA Entity into UserDto
	public static AuthorDto mapToAuthorDto(Author author) {
		AuthorDto authorDto = new AuthorDto(author.getAuthorId(), author.getAuthorName(),author.isDeleted());
		return authorDto;

	}

	// Convert AuthorDto into User JPA Entity
	public static Author mapToAuthor(AuthorDto authorDto) {
		Author author = new Author(authorDto.getAuthorId(), authorDto.getAuthorName(), authorDto.isDeleted());
		return author;
	}
}