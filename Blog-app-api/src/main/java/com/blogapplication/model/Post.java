package com.blogapplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer postId;
	String postName;
	boolean deleted = false;

	@OneToOne(cascade = CascadeType.ALL)
	Category category;

	@ManyToOne(cascade = CascadeType.ALL)
	User user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;

}