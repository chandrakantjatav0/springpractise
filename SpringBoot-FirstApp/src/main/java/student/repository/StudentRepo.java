package student.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, String> {

}
