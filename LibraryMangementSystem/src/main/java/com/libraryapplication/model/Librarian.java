package com.libraryapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "librarian")
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer librarianId;
	private String librarianName;
	private boolean deleted;
}