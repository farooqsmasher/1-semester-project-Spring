package com.studinfosys.dao;

import java.util.List;

import com.studinfosys.entity.TblUser;

public interface TblUserDAO {
	public void addTblUser(TblUser tblUser);
	 public List<TblUser> getAllTblUser();
	 public TblUser getTblUserByUserName(String userName);
	 public void deleteTblUserByUserName(String userName);


}
