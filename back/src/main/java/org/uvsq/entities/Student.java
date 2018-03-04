package org.uvsq.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Student extends User{

	private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	private String adress;
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Student_Ue",
            joinColumns = {@JoinColumn(name = "Student_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Ue_ID", referencedColumnName = "ID")})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Ue> ues;
	
	public Student() {}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Ue> getUes() {
		return ues;
	}

	public void setUes(List<Ue> ues) {
		this.ues = ues;
	}

	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", firstName=" + firstName + ", adress=" + adress + ", email=" + email
				+ "]";
	}
	
	
	
}
