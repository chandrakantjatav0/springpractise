package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Model.Movie;

public interface MovieRepository  extends JpaRepository < Movie , Float>{

}
