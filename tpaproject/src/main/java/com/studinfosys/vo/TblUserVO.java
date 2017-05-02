package com.studinfosys.vo;

import com.studinfosys.entity.TblUser;
import com.studinfosys.entity.TblUserRole;

public class TblUserVO {
private TblUser tblUser;
private TblUserRole tblUserRole;
public TblUser getTblUser() {
	return tblUser;
}
public void setTblUser(TblUser tblUser) {
	this.tblUser = tblUser;
}
public TblUserRole getTblUserRole() {
	return tblUserRole;
}
public void setTblUserRole(TblUserRole tblUserRole) {
	this.tblUserRole = tblUserRole;
}



}
