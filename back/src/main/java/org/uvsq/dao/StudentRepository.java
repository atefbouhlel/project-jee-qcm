package org.uvsq.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uvsq.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	public List<Student> findByUsername(String username);
}
