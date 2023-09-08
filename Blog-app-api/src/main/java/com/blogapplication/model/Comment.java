package com.blogapplication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer commentId;
	String comments;
	boolean deleted = false;

	@ManyToOne(cascade = CascadeType.ALL)
	Post post;

	@ManyToOne(cascade = CascadeType.ALL)
	User user;

}
