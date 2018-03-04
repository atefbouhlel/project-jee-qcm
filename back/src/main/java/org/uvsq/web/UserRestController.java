package org.uvsq.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uvsq.dao.ProfessorRepository;
import org.uvsq.dao.UeRepository;
import org.uvsq.entities.Professor;
import org.uvsq.entities.QCM;
import org.uvsq.entities.Student;
import org.uvsq.entities.Ue;
import org.uvsq.entities.User;
import org.uvsq.security.jwt.JwtTokenUtil;
import org.uvsq.security.jwt.JwtUser;
import org.uvsq.services.IQcmService;
import org.uvsq.services.IUserService;
import org.uvsq.services.QcmService;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
	IUserService userService;
    
    @Autowired
    IQcmService qcmService;
    
    @Autowired
	ProfessorRepository profRepo;
    
    @Autowired
    UeRepository ueRepository;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(HttpServletRequest request) {        
        return userService.getAll();
    }
    
    @RequestMapping(value="admin/students", method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> getStudents(){
		return userService.getAllStudents();
	}

    @RequestMapping(value="admin/students/create", method=RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
	public Student saveStudent(@RequestBody Student student){
		return userService.addStudent(student);
	}
    
    @RequestMapping(value="admin/students/update/{id}", method=RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
    	System.out.println(id);
    	System.out.println(student);
    	
    	Student selectedStudent = userService.findStudentById(id);
    	selectedStudent.setUsername(student.getUsername());
    	selectedStudent.setFirstName(student.getFirstName());
    	selectedStudent.setLastName(student.getLastName());
    	selectedStudent.setAdress(student.getAdress());
    	selectedStudent.setEmail(student.getEmail());
		return userService.updateStudent(selectedStudent);
	}
    
    @RequestMapping(value="admin/students/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
	public Student updateStudent2(@PathVariable Long id, @RequestBody Student student){
    	Student selectedStudent = userService.findStudentById(id);
    	selectedStudent.setUsername(student.getUsername());
    	selectedStudent.setFirstName(student.getFirstName());
    	selectedStudent.setLastName(student.getLastName());
    	selectedStudent.setAdress(student.getAdress());
    	selectedStudent.setEmail(student.getEmail());
		return userService.updateStudent(selectedStudent);
	}
    
    @RequestMapping(value="admin/students/{id}", method=RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
	public boolean deleteStudent(@PathVariable Long id){
		userService.deleteStudent(id);
		return true;
	}
    
    @RequestMapping(value="admin/students/delete/{id}", method=RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
	public boolean deleteStudent2(@PathVariable Long id){
		userService.deleteStudent(id);
		return true;
	}
    
    @RequestMapping(value = "professor/myues", method = RequestMethod.GET)
    public List<Ue> getUesProfessor(HttpServletRequest request) {
    	String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Professor currentProf = userService.getProfByUsername(username);
        System.out.println(ueRepository.findByName("C++"));
        if(currentProf.getUes().size() == 0)
        	return ueRepository.findByName("C++");
//        	System.out.println("000000000");
//        	userService.initUeProf(currentProf);
        
        System.out.println(currentProf);
        
        return currentProf.getUes();
    }
    
    @RequestMapping(value = "student/myqcms", method = RequestMethod.GET)
    public List<QCM> getStudentQcms(HttpServletRequest request) {
    	System.out.println("test12");
    	String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println(username);
        Student currentStudent = userService.getStudentByUsername(username);        
        System.out.println(currentStudent);
        
        return qcmService.getAll();
//        return qcmService.getStudentQcms(currentStudent);
    }
    
    
}
