package com.studinfosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studinfosys.dao.TblUserDAO;
import com.studinfosys.entity.TblUser;
@Service
public class TblUserServiceImpl implements TblUserService {

	@Autowired
	TblUserDAO tblUserDAO;
	public void doAddTblUser(TblUser tblUser) {
		// TODO Auto-generated method stub
		tblUserDAO.addTblUser(tblUser);
	}

	public List<TblUser> doGetAllTblUser() {
		// TODO Auto-generated method stub
		return tblUserDAO.getAllTblUser();
	}

	public TblUser doGetTblUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return tblUserDAO.getTblUserByUserName(userName);
	}

	public void doDeleteTblUserByUserName(String userName) {
		// TODO Auto-generated method stub
		tblUserDAO.deleteTblUserByUserName(userName);
	}

}
