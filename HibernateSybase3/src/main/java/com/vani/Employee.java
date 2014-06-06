package com.vani;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {

	private Long employeeId;

	private String firstname;

	private String lastname;

	private Date birthDate;

	private String cellphone;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	
}
