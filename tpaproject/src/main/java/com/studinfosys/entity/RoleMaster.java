package com.studinfosys.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the role_master database table.
 * 
 */
@Entity
@Table(name="role_master")
@NamedQuery(name="RoleMaster.findAll", query="SELECT r FROM RoleMaster r")
public class RoleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="role_id")
	private String roleId;

	@Column(name="Role_Desc")
	private String roleDesc;

	//bi-directional many-to-many association to TblUser


	//bi-directional many-to-one association to TblUserRole
	@OneToMany(mappedBy="roleMaster")
	private List<TblUserRole> tblUserRoles;

	public RoleMaster() {
	}

	


	public String getRoleId() {
		return roleId;
	}




	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}





	public String getRoleDesc() {
		return roleDesc;
	}




	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}




	public List<TblUserRole> getTblUserRoles() {
		return this.tblUserRoles;
	}

	public void setTblUserRoles(List<TblUserRole> tblUserRoles) {
		this.tblUserRoles = tblUserRoles;
	}

	public TblUserRole addTblUserRole(TblUserRole tblUserRole) {
		getTblUserRoles().add(tblUserRole);
		tblUserRole.setRoleMaster(this);

		return tblUserRole;
	}

	public TblUserRole removeTblUserRole(TblUserRole tblUserRole) {
		getTblUserRoles().remove(tblUserRole);
		tblUserRole.setRoleMaster(null);

		return tblUserRole;
	}

}