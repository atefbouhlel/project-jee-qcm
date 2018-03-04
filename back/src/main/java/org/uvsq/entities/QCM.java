package org.uvsq.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QCM implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	private String name;
	private String theme;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "dd-MM-yyyy")
	private Date startdate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "dd-MM-yyyy")
	private Date enddate;
	private int difficulty;
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ID")*/
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "QCM_Question",
            joinColumns = {@JoinColumn(name = "QCM_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Question_ID", referencedColumnName = "ID")})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Question> questions;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "QCM_UE",
            joinColumns = {@JoinColumn(name = "QCM_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "UE_ID", referencedColumnName = "ID")})
    private List<Ue> ues;
	
	public QCM() {
		super();
	}
	public QCM(String name, String theme, Date startdate, Date enddate, int difficulty) {
		super();
		this.name = name;
		this.theme = theme;
		this.startdate = startdate;
		this.enddate = enddate;
		this.difficulty = difficulty;
		this.questions = new ArrayList<>();
		this.ues = new ArrayList<>();
	}
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	@JsonIgnore
	public List<Ue> getUes() {
		return ues;
	}
	public void setUes(List<Ue> ues) {
		this.ues = ues;
	}
	@Override
	public String toString() {
		return "QCM [id=" + id + ", name=" + name + ", theme=" + theme + ", difficulty=" + difficulty + "]";
	}
	
	
	
	
}
