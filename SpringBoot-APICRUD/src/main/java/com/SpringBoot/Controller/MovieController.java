package com.SpringBoot.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Dto.MovieDto;
import com.SpringBoot.Model.Movie;
import com.SpringBoot.Service.MovieService;
import com.SpringBoot.Service.Impl.MovieServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	private MovieServiceImpl movieservice;

	// buid create REST API
	@PostMapping("/save")
	public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
		return new ResponseEntity<MovieDto>(movieservice.createMovie(movieDto), HttpStatus.CREATED);
	}

	// build get all Movies REST APIf
	@GetMapping("/mapp")
	public ResponseEntity<List<MovieDto>> getAllMovie() {
		List<MovieDto> movie = movieservice.getAllMovie();
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	// Build get all Movie by Id REST API
	// http:localhost:9000/api/movies/2
	@GetMapping("{id}")
	public ResponseEntity<MovieDto> getMovieById(@PathVariable("id") Float movieId) {
		try {
			return new ResponseEntity<MovieDto>(movieservice.getMovieById(movieId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Build Update movie REST API
	// http:localhost:9000/api/movies/1
	@PutMapping("{id}")
	public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") float id, @RequestBody MovieDto movieDto) {
		try {
			return new ResponseEntity<MovieDto>(movieservice.updateMovie(movieDto, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Build delete Movie REST API
	// http:localhost:9000/api/movies/3
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable("id") float id) {
		// Delete Movie From DB
		try {
			movieservice.deleteMovie(id);
			return new ResponseEntity<String>("Employee Deleted SuccessFully!.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
