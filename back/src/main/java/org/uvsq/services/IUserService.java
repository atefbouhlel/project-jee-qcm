package org.uvsq.services;

import java.util.List;

import org.uvsq.entities.Professor;
import org.uvsq.entities.Student;
import org.uvsq.entities.User;


public interface IUserService {
	User add(User user);
	User get(Long userId);
	List<User> getAll();
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudent(Long id);
	void deleteStudent(Long id);
	Student findStudentById(Long id);
	Student updateStudent(Student selectedStudent);
	
	Professor getProfByUsername(String username);
	Student getStudentByUsername(String username);
	void initUeProf(Professor prof);
	
}
