package org.uvsq.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.uvsq.dao.ProfessorRepository;
import org.uvsq.dao.StudentRepository;
import org.uvsq.dao.UserRepository;
import org.uvsq.entities.Authority;
import org.uvsq.entities.AuthorityName;
import org.uvsq.entities.Professor;
import org.uvsq.entities.Student;
import org.uvsq.entities.Ue;
import org.uvsq.entities.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public User add(User user) {
		return userRepository.save(user);
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {

		List<Authority> authoritiesStudent = new ArrayList<>();
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());

		student.setPassword(passwordEncoder().encode("1234"));
		student.setEnabled(true);

		student.setLastPasswordResetDate(timestamp);
		Authority auS = new Authority();
		auS.setName(AuthorityName.ROLE_STUDENT);
		authoritiesStudent.add(auS);
		student.setAuthorities(authoritiesStudent);

		return studentRepository.save(student);
	}

	
	@Override
	public Student updateStudent(Student selectedStudent) {
		// TODO Auto-generated method stub
		return studentRepository.save(selectedStudent);
	}

	@Override
	public Student findStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findOne(id);
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.getOne(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);		
	}

	@Override
	public Professor getProfByUsername(String username) {
		// TODO Auto-generated method stub
		return professorRepository.findByUsername(username).get(0);
	}
	
	@Override
	public void initUeProf(Professor prof) {
		List<Ue> uesProf = new ArrayList<>();
		Ue ue1 = new Ue();
		ue1.setName("BD");
		
		Ue ue2 = new Ue();
		ue2.setName("NoSQL");
		
		Ue ue3 = new Ue();
		ue3.setName("Big Data");
		
		Ue ue4 = new Ue();
		ue4.setName("JEE");
		
		uesProf.add(ue1);
		uesProf.add(ue2);
		uesProf.add(ue4);
		
		prof.setUes(uesProf);
		
		professorRepository.save(prof);
    }

	@Override
	public Student getStudentByUsername(String username) {
		System.out.println("--------");
		System.out.println(username);
		return studentRepository.findByUsername(username).get(0);
	}
	
	
	

}
