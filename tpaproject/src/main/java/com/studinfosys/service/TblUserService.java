package com.studinfosys.service;

import java.util.List;

import com.studinfosys.entity.TblUser;

public interface TblUserService {
	public void doAddTblUser(TblUser tblUser);
	 public List<TblUser> doGetAllTblUser();
	 public TblUser doGetTblUserByUserName(String userName);
	 public void doDeleteTblUserByUserName(String userName);
}
