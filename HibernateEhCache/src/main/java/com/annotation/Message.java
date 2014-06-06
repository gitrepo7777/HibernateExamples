package com.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="MESSAGES", schema="vani")
@Cache(region = "messages", usage = CacheConcurrencyStrategy.READ_WRITE)

public class Message {
	
	Message(){
		
	}
	Message(String message){
		message_text=message;
	}
	@Id @GeneratedValue
	@Column(name="MESSAGE_ID")
	public Long id;
	@Column(name="MESSAGE_TEXT")
	public String message_text;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	
	
	
	
}
