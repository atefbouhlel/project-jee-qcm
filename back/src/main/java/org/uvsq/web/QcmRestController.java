package org.uvsq.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uvsq.entities.QCM;
import org.uvsq.entities.Question;
import org.uvsq.services.IQcmService;


@RestController
public class QcmRestController {

	@Autowired
	IQcmService qcmService;
	
	
	@RequestMapping(value="/qcms", method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<QCM> getQuestions(){
		return qcmService.getAll();
	}
	
	@RequestMapping(value="/qcms/{id}", method=RequestMethod.GET)
	public QCM getQuestion(@PathVariable Long id){
		return qcmService.get(id);
	}
	
	@RequestMapping(value="/qcms/create", method=RequestMethod.POST)
	public QCM saveQuestion(@RequestBody QCM qcm){
		System.out.println(qcm);
		System.out.println("---");
		
//		List<Question> questionsList = new ArrayList<>();
//		qcm.getQuestions().forEach(q -> {
//			questionsList.add(q);
//		});
//		qcm.setQuestions(questionsList);
		
		System.out.println("---");
		System.out.println(qcm.getQuestions());
		System.out.println("ih");
		System.out.println(qcm.getUes());
		//return new QCM();
		return qcmService.add(qcm);
	}
	
	@RequestMapping(value="/qcms/test", method=RequestMethod.GET)
	public List<QCM> test(){
		return qcmService.test();
		
	}
	/*
	@RequestMapping(value="/qcms/{id}", method=RequestMethod.DELETE)
	public boolean deleteQuestion(@PathVariable Long id){
		qcmRepository.delete(id);
		return true;
	}
	
	@RequestMapping(value="/qcms/{id}", method=RequestMethod.PUT)
	public QCM updateQuestion(@PathVariable Long id, @RequestBody QCM q){
		q.setId(id);
		return qcmRepository .save(q);
	}*/
}
