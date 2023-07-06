package com.SpringBoot.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private Float imdbRatings;
	private String director;
	private String genre;
	private String movieName;

}
