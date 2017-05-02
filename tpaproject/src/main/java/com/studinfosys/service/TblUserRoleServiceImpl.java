package com.studinfosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studinfosys.dao.TblUserRoleDAO;
import com.studinfosys.entity.TblUserRole;
@Service
public class TblUserRoleServiceImpl implements TblUserRoleService {

	@Autowired
	TblUserRoleDAO tblUserRoleDAO;
	
	public void doAddTblUserRole(TblUserRole tblUserRole) {
		// TODO Auto-generated method stub
		tblUserRoleDAO.addTblUserRole(tblUserRole);
	}

	public List<TblUserRole> doGetAllTblUserRole() {
		// TODO Auto-generated method stub
		return tblUserRoleDAO.getAllTblUserRole();
	}

	public List<TblUserRole> doGetTblUserRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return tblUserRoleDAO.getTblUserRoleByUserName(userName);
	}

	public void doDeleteTblUserRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		tblUserRoleDAO.deleteTblUserRoleByUserName(userName);
	}

}
