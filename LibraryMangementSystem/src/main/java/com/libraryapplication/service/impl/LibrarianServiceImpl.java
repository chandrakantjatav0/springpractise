package com.libraryapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.libraryapplication.dto.LibrarianDto;
import com.libraryapplication.exception.ResourceNotFoundException;
import com.libraryapplication.mapper.LibrarianMapper;
import com.libraryapplication.model.Librarian;
import com.libraryapplication.repository.LibrarianRepository;
import com.libraryapplication.service.LibrarianSevice;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LibrarianServiceImpl implements LibrarianSevice {

	private LibrarianRepository librarianRepo;

	@Override
	public LibrarianDto createLibrarian(LibrarianDto librarianDto) throws ResourceNotFoundException {
		Librarian librarian = new Librarian();
		if (librarianDto.getLibrarianId() != null) {
			librarian = this.librarianRepo.findById(librarianDto.getLibrarianId())
					.orElseThrow(() -> new ResourceNotFoundException("Librarian not found!.."));
		}
		librarian.setLibrarianName(librarianDto.getLibrarianName());
		librarianRepo.save(librarian);
		return LibrarianMapper.mapToLibrarianDto(librarian);
	}

	@Override
	public List<LibrarianDto> getAllLibrarian() {
		List<Librarian> librarian = librarianRepo.findAll();
		return librarian.stream().map(LibrarianMapper::mapToLibrarianDto).collect(Collectors.toList());
	}

	@Override
	public LibrarianDto getLibrarianById(Integer librarianId) throws ResourceNotFoundException {
		Librarian librarian = librarianRepo.findById(librarianId)
				.orElseThrow(() -> new ResourceNotFoundException("Librarian not found!.."));
		return LibrarianMapper.mapToLibrarianDto(librarian);
	}

	@Override
	public String softDeleteLibrarian(Integer id) throws ResourceNotFoundException {
		// we need to Check whether Book exist in DB or not
		Librarian librarian = librarianRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Librarian not found!.."));
		librarian.setDeleted(true);
		librarianRepo.save(librarian);
		return "Soft deleted this Record!..";
	}

	@Override
	public String deleteLibrarian(Integer id) throws ResourceNotFoundException {
		librarianRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Librarian not found!.."));
		librarianRepo.deleteById(id);
		return "Librarian Deleted Successfully";
	}
}
