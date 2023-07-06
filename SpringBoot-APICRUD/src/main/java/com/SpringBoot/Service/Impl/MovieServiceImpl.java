package com.SpringBoot.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringBoot.Dto.MovieDto;
import com.SpringBoot.Exception.ResourceNotFoundException;
import com.SpringBoot.Mapper.MovieMapper;
import com.SpringBoot.Model.Movie;
import com.SpringBoot.Repository.MovieRepository;
import com.SpringBoot.Service.MovieService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepo;

	@Override
	public MovieDto createMovie(MovieDto movieDto) {

		// Convert MovieDto into User JPA Entity
		Movie movie = MovieMapper.mapToMovie(movieDto);

		Movie savedMovie = movieRepo.save(movie);

		// Convert User JPA entity to MovieDto
		MovieDto savedMovieDto = MovieMapper.mapToMovieDto(savedMovie);

		return savedMovieDto;
	}

	@Override
	public List<MovieDto> getAllMovie() {
		List<Movie> movie = movieRepo.findAll();
		return movie.stream().map(MovieMapper::mapToMovieDto).collect(Collectors.toList());
	}

	@Override
	public MovieDto getMovieById(Float movieId) {
		Movie movie = movieRepo.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", movieId));
		return MovieMapper.mapToMovieDto(movie);

	}

	@Override
	public MovieDto updateMovie(MovieDto movieDto, float movieId) {
		// we need to check whether movie with given id is exist in DB or not
		Movie existingMovie = movieRepo.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", movieId));
		existingMovie.setDirector(movieDto.getDirector());
		existingMovie.setMovieName(movieDto.getMovieName());
		existingMovie.setGenre(movieDto.getGenre());
		// save existing movie to DB
		movieRepo.save(existingMovie);
		return MovieMapper.mapToMovieDto(existingMovie);
	}

	@Override
	public void deleteMovie(float movieId) {
		// we need to Check whether movie exist in DB or not
		movieRepo.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", movieId));
		movieRepo.deleteById(movieId);
	}

}
