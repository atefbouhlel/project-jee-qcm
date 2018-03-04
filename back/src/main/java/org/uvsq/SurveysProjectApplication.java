package org.uvsq;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.uvsq.dao.ProfessorRepository;
//import org.springframework.security.core.userdetails.User;
import org.uvsq.dao.QCMRepository;
import org.uvsq.dao.QuestionRepository;
import org.uvsq.dao.StudentRepository;
import org.uvsq.dao.UeRepository;
import org.uvsq.dao.UserRepository;
import org.uvsq.entities.Authority;
import org.uvsq.entities.AuthorityName;
import org.uvsq.entities.Professor;
import org.uvsq.entities.Student;
import org.uvsq.entities.Ue;
import org.uvsq.entities.User;
import org.uvsq.services.IUserService;

@SpringBootApplication
public class SurveysProjectApplication implements CommandLineRunner {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QCMRepository qcmRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private UeRepository ueRepository;

	@Autowired
	IUserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SurveysProjectApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... arg0) throws Exception {
		initDatabase();
		
		qcmRepository.findAll().forEach(qcm -> {
			System.out.println(qcm.getName());
			System.out.println(qcm.getQuestions());
			System.out.println(qcm.getUes());
		});
		questionRepository.findAll().forEach(q -> {
			System.out.println(q.getContent());
			//System.out.println(q.getQcm());
		});


	}
	
	private void initDatabase() {
		/*
		 * questionRepository.save(new Question("what ??", 2, "jee"));
		 * questionRepository.save(new Question("who ??", 1, "jee"));
		 */
		/*
		 * DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); Date today = new Date();
		 * qcmRepository.save(new QCM("JeeExam",
		 * "Exam S1",df.parse(df.format(today)),df.parse(df.format(today)), 1));
		 */

		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		
		List<Authority> authoritiesAdmin = new ArrayList<>();

		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder().encode("admin"));
		admin.setEnabled(true);

		admin.setLastPasswordResetDate(timestamp);
		Authority au2 = new Authority();
		au2.setName(AuthorityName.ROLE_ADMIN);
		authoritiesAdmin.add(au2);
		admin.setAuthorities(authoritiesAdmin);

		userRepository.save(admin);

		List<Authority> authoritiesStudent = new ArrayList<>();
		List<Ue> uesStudent = new ArrayList<>();

		Student student = new Student();
		student.setUsername("student1");
		student.setEmail("student@uvsq.com");
		student.setFirstName("student");
		student.setLastName("student");
		student.setAdress("StudentAdress");
		student.setPassword(passwordEncoder().encode("student"));
		student.setEnabled(true);

		student.setLastPasswordResetDate(timestamp);
		Ue ueS = new Ue();
		ueS.setName("C++");
		uesStudent.add(ueS);
		
		Ue ue2S = new Ue();
		ue2S.setName("Intégration des données");
		uesStudent.add(ue2S);
		
		student.setUes(uesStudent);		
		
		student.setAuthorities(authoritiesStudent);

		studentRepository.save(student);
		
		List<Authority> authoritiesProf = new ArrayList<>();
		List<Ue> uesProf = new ArrayList<>();
		
		Professor prof = new Professor();
		prof.setUsername("prof");
		prof.setEmail("prof@uvsq.com");
		prof.setFirstName("prof1");
		prof.setLastName("prof1");
		prof.setAdress("prof1Adress");
		prof.setPassword(passwordEncoder().encode("prof"));
		prof.setEnabled(true);

		prof.setLastPasswordResetDate(timestamp);
		/*
		Ue ueP = ueRepository.findByName("C++").get(0);
		uesProf.add(ueP);
		
		Ue ue2P = ueRepository.findByName("Intégration des données").get(0);
		uesProf.add(ue2P);
		
		prof.setUes(uesProf);	
		*/
		Authority auP = new Authority();
		auP.setName(AuthorityName.ROLE_PROFESSOR);
		authoritiesProf.add(auP);
		prof.setAuthorities(authoritiesProf);

		professorRepository.save(prof);
	}
}
