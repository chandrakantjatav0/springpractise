package com.libraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianDto {
	private Integer librarianId;
	private String librarianName;
	private boolean deleted = false;
}