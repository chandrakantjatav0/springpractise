package com.SpringBoot.Mapper;

import com.SpringBoot.Dto.MovieDto;
import com.SpringBoot.Model.Movie;

public class MovieMapper {

	// Convert Movie JPA Entity into UserDto
	public static MovieDto mapToMovieDto(Movie movie) {
		MovieDto movieDto = new MovieDto(movie.getImdbRatings(), movie.getMovieName(), movie.getDirector(),
				movie.getGenre());
		return movieDto;
	}

	// Convert MovieDto into User JPA Entity
	public static Movie mapToMovie(MovieDto movieDto) {
		Movie movie = new Movie(movieDto.getImdbRatings(), movieDto.getMovieName(), movieDto.getDirector(),
				movieDto.getGenre());
		return movie;
	}
}