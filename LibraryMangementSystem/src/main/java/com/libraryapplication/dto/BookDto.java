package com.libraryapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private Integer bookId;
	private String bookName;
	private boolean deleted = false;
}
