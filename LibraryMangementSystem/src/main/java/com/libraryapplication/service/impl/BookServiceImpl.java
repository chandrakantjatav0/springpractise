package com.libraryapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.libraryapplication.dto.BookDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.mapper.BookMapper;
import com.libraryapplication.model.Book;
import com.libraryapplication.repository.BookRepository;
import com.libraryapplication.service.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

	private BookRepository bookRepo;

	@Override
	public BookDto createBook(BookDto bookDto) throws ResourceNotFoundException {
		Book book = new Book();
		if (bookDto.getBookId() != null) {
			book = this.bookRepo.findById(bookDto.getBookId())
					.orElseThrow(() -> new ResourceNotFoundException("Author not found!.."));
		}
		book.setBookName(bookDto.getBookName());
		bookRepo.save(book);
		return BookMapper.mapToBookDto(book);
	}

	@Override
	public List<BookDto> getAllBook() {
		List<Book> book = bookRepo.findAll();
		return book.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());
	}

	@Override
	public BookDto getBookById(Integer bookId) throws ResourceNotFoundException {
		Book book = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found!.."));
		return BookMapper.mapToBookDto(book);
	}

	@Override
	public String softDeleteBook(Integer id) throws ResourceNotFoundException {
		// we need to Check whether Book exist in DB or not
		Book book = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found!.."));
		book.setDeleted(true);
		bookRepo.save(book);
		return "Soft deleted this Record!..";
	}

	@Override
	public String deleteBook(Integer id) throws ResourceNotFoundException {
		bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found!.."));
		bookRepo.deleteById(id);
		return "Book Deleted Sucessfully!...";
	}

}