package com.vani;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Meeting {
	
	private Long meetingId;
	private String subject;
	private Date meetingDate;
	
	Set<Employee> employees = new HashSet<Employee>();
	
	public Meeting(String subject)
	{
		this.subject = subject;
	}
	
	public Meeting(String subject, Date meetingDate)
	{
		this.subject = subject;
		this.meetingDate = meetingDate;
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	

}
