package com.vani;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting {
	
	@Id
	@GeneratedValue
	@Column(name="meeting_id")
	private Long meetingId;
	
	@Column
	private String subject;
	
	@Column
	private Date meetingDate;
	
	@ManyToMany(mappedBy="meetings")
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
