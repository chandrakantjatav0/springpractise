package com.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryapplication.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}