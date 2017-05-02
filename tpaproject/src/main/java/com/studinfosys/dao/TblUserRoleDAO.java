package com.studinfosys.dao;

import java.util.List;

import com.studinfosys.entity.TblUserRole;

public interface TblUserRoleDAO {
	public void addTblUserRole(TblUserRole tblUserRole);
	 public List<TblUserRole> getAllTblUserRole();
	 public List<TblUserRole> getTblUserRoleByUserName(String userName);
	 public void deleteTblUserRoleByUserName(String userName);
}
