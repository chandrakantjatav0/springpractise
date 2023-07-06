package com.cartoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartoon.model.Cartoon;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Integer>{

}
