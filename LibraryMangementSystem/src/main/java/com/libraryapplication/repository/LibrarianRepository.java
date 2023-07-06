package com.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapplication.model.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
