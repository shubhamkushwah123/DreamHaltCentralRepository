package com.dh.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Verification {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="v_id")
	long vId;
	
	@Column(name="v_type")
	String vType;
	
	@Column(name="v_attachment")
	String vAttachment;

	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getVId() {
		return vId;
	}

	public void setVId(long vId) {
		this.vId = vId;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public String getvAttachment() {
		return vAttachment;
	}

	public void setvAttachment(String vAttachment) {
		this.vAttachment = vAttachment;
	}
	
	
	
	
	

}
