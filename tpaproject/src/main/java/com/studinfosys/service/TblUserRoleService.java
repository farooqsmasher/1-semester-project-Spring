package com.studinfosys.service;

import java.util.List;

import com.studinfosys.entity.TblUserRole;

public interface TblUserRoleService {
	public void doAddTblUserRole(TblUserRole tblUserRole);
	 public List<TblUserRole> doGetAllTblUserRole();
	 public List<TblUserRole> doGetTblUserRoleByUserName(String userName);
	 public void doDeleteTblUserRoleByUserName(String userName);
}
