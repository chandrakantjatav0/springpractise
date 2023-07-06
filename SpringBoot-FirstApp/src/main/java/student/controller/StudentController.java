package student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import student.entity.Student;

@RestController
public class StudentController {

	// http://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String hello() {
		return "Hello World";
	}

	// // http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(10, "Ramesh", 24, "Fadatare");
	}

}
