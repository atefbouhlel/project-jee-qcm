package org.uvsq.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Question implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	private String content;
	/*
	@ManyToOne
	private QCM qcm;
	*/
	@ManyToOne(fetch=FetchType.EAGER)
	private QCM qcm;
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Question_Answer",
            joinColumns = {@JoinColumn(name = "Question_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Answer_ID", referencedColumnName = "ID")})
	@Fetch(value = FetchMode.SUBSELECT)
	//	@JoinColumn(name="ID")	
	private List<Answer> answers;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Question(String content, int difficulty, String theme) {
		super();
		this.content = content;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
/*
	@JsonIgnore
	public QCM getQcm() {
		return qcm;
	}


	public void setQcm(QCM qcm) {
		this.qcm = qcm;
	}
	*/
	
	


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + "\n"+ getAnswers()+"\n]";
	}
	
	
	
}
