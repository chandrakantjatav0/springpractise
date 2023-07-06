package com.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapplication.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
