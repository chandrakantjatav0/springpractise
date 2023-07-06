package com.libraryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.libraryapplication.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
