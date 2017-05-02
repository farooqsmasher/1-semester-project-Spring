package com.studinfosys.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_users database table.
 * 
 */
@Entity
@Table(name="tbl_users")
@NamedQuery(name="TblUser.findAll", query="SELECT t FROM TblUser t")
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private String username;

	private String designation;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	private String email;

	private int enabled;

	@Column(name="first_name")
	private String firstName;



	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_no")
	private BigInteger mobileNo;

	private String oldpassword;

	private String password;

	//bi-directional many-to-one association to TblUserRole
	@OneToMany(fetch = FetchType.EAGER,mappedBy="tblUser")
	private List<TblUserRole> tblUserRoles;



	

	public TblUser() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOldpassword() {
		return this.oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TblUserRole> getTblUserRoles() {
		return this.tblUserRoles;
	}

	public void setTblUserRoles(List<TblUserRole> tblUserRoles) {
		this.tblUserRoles = tblUserRoles;
	}





}