package org.uvsq.services;

import java.util.List;

import org.uvsq.entities.QCM;
import org.uvsq.entities.Student;

public interface IQcmService {
	List<QCM> getAll();
	QCM get(Long id);
	QCM add(QCM qcm);
	
	List<QCM> getStudentQcms(Student student);
	
	List<QCM> test();
	
}
