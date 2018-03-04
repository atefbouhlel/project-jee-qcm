package org.uvsq.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uvsq.dao.QuestionRepository;
import org.uvsq.entities.Question;

@RestController
public class QuestionRestController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public List<Question> getQuestions(){
		return questionRepository.findAll();
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.GET)
	public Question getQuestion(@PathVariable Long id){
		return questionRepository.findOne(id);
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public Question saveQuestion(@RequestBody Question q){
		return questionRepository.save(q);
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.DELETE)
	public boolean deleteQuestion(@PathVariable Long id){
		questionRepository.delete(id);
		return true;
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.PUT)
	public Question updateQuestion(@PathVariable Long id, @RequestBody Question q){
		q.setId(id);
		return questionRepository.save(q);
	}
	
}
