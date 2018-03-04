package org.uvsq.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ue implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Professor professor;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Student> students;

	@ManyToMany(mappedBy = "ues", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<QCM> qcms;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@JsonIgnore
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<QCM> getQcms() {
		return qcms;
	}

	public void setQcms(List<QCM> qcms) {
		this.qcms = qcms;
	}

	@Override
	public String toString() {
		return "Ue [id=" + id + ", name=" + name + "]";
	}
	
	

}
