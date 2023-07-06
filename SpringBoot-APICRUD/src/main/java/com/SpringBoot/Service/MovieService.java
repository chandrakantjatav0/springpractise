package com.SpringBoot.Service;

import java.util.List;

import com.SpringBoot.Dto.MovieDto;

public interface MovieService {

	MovieDto createMovie(MovieDto movieDto);

	List<MovieDto> getAllMovie();

	MovieDto getMovieById(Float id);

	MovieDto updateMovie(MovieDto movieDto, float id);

	void deleteMovie(float id);
}
