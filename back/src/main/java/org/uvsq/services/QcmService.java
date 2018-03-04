package org.uvsq.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uvsq.dao.QCMRepository;
import org.uvsq.dao.QuestionRepository;
import org.uvsq.entities.QCM;
import org.uvsq.entities.Student;

@Service
public class QcmService implements IQcmService {

	@Autowired
	private QCMRepository qcmRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<QCM> getAll() {
		return qcmRepository.findAll();
	}

	@Override
	public QCM get(Long id) {
		return qcmRepository.findOne(id);
	}

	@Override
	public QCM add(QCM qcm) {
		return qcmRepository.save(qcm);
	}
	
	public List<QCM> getStudentQcms(Student student){
		List<QCM> studentQcms = new ArrayList<>();
		student.getUes().forEach(ue -> {
			if( ue.getQcms().size() != 0)
				ue.getQcms().forEach(qcm ->{
					System.out.println("fghj");
					studentQcms.add(qcm);
				});
		});
		
		return studentQcms;
	}
	
	public List<QCM> test() {
		qcmRepository.findAll().forEach(qcm -> {
			System.out.println(qcm.getName());
			System.out.println(qcm.getQuestions());
			System.out.println(qcm.getUes());
		});
		questionRepository.findAll().forEach(q -> {
			System.out.println(q.getContent());
			//System.out.println(q.getQcm());
			System.out.println(q.getAnswers());
		});
		
		return qcmRepository.findAll();
	}
}
