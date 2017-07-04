package com.commonservices.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserModel {
	
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private String createdby;
	private String modifiedby;
	private Date createdat;
	private Date modifiedat;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public Date getModifiedat() {
		return modifiedat;
	}
	public void setModifiedat(Date modifiedat) {
		this.modifiedat = modifiedat;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(Long id, String username, String password, String email, String createdby, String modifiedby,
			Date createdat, Date modifiedat) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.createdat = createdat;
		this.modifiedat = modifiedat;
	}
	
	

}
