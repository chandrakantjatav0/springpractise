package com.libraryapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.libraryapplication.dto.AuthorDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.mapper.AuthorMapper;
import com.libraryapplication.model.Author;
import com.libraryapplication.repository.AuthorRepository;
import com.libraryapplication.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
	private AuthorRepository authorRepo;

	@Override
	public AuthorDto createAuthor(AuthorDto authorDto) throws ResourceNotFoundException {
		Author author = new Author();
		if (authorDto.getAuthorId() != null) {
			author = this.authorRepo.findById(authorDto.getAuthorId())
					.orElseThrow(() -> new ResourceNotFoundException("Author not found!.."));
		}
		author.setAuthorName(authorDto.getAuthorName());
		authorRepo.save(author);
		return AuthorMapper.mapToAuthorDto(author);
	}

	@Override
	public List<AuthorDto> getAllAuthor() {
		List<Author> author = authorRepo.findAll();
		return author.stream().map(AuthorMapper::mapToAuthorDto).collect(Collectors.toList());
	}

	@Override
	public AuthorDto getAuthorById(Integer authorId) throws ResourceNotFoundException {
		Author author = authorRepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found!.."));
		return AuthorMapper.mapToAuthorDto(author);
	}

	
	@Override
	public String softDeleteAuthor(Integer id) throws ResourceNotFoundException {
		Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found!.."));
		author.setDeleted(true);
		authorRepo.save(author);
		return "Soft deleted this Record!..";
	}

	@Override
	public String deleteAuthor(Integer id) throws ResourceNotFoundException {
		authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found!.."));
		authorRepo.deleteById(id);
		return "Author Deleted Successfully";

	}

}
