package com.vani;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;

	@Column
	private String firstname;

	@Column
	private String lastname;



	@ManyToMany
	@JoinTable(name="EMPOYEE_MEETING", joinColumns={@JoinColumn(name="employee_id")}, 
					inverseJoinColumns={@JoinColumn(name="meeting_id")})
	Set<Meeting> meetings = new HashSet<Meeting>();

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

	public Employee() {
	}

	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	
}
