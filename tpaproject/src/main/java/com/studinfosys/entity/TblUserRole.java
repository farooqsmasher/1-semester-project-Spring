package com.studinfosys.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tbl_user_role database table.
 * 
 */
@Entity
@Table(name="tbl_user_role")
@NamedQuery(name="TblUserRole.findAll", query="SELECT t FROM TblUserRole t")
public class TblUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to TblUser
	@ManyToOne
	@JoinColumn(name="username")
	private TblUser tblUser;

	//bi-directional many-to-one association to RoleMaster
	@ManyToOne
	@JoinColumn(name="rolename")
	private RoleMaster roleMaster;

	public TblUserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TblUser getTblUser() {
		return this.tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

}