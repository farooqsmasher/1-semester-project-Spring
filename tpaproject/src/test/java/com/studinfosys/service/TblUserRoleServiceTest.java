package com.studinfosys.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.studinfosys.dao.TblUserRoleDAO;
import com.studinfosys.entity.RoleMaster;
import com.studinfosys.entity.TblUser;
import com.studinfosys.entity.TblUserRole;

public class TblUserRoleServiceTest {
	
	
	@Autowired
	TblUserRoleService tblUserRoleService;
	@Autowired
	RoleMasterService roleMasterService;
	
	@Autowired
	TblUserRoleDAO tblUserRoleDAO;
	TblUserRole  testRole;


	@Before
	public void tblUsertestBefore(){
		
		TblUser tblUser = new TblUser();
	RoleMaster roleMaster = new RoleMaster();
	
	
	
	TblUserRole tblUserRole =new TblUserRole();
	tblUserRole.setId(3);
	
	tblUser.setUsername("hacker");
	  
	  tblUser.setPassword("hacker");
	  tblUser.setEnabled(1);
	  tblUserRole.setRoleMaster(roleMaster);
	  roleMaster.setRoleId("ROLE_ADMIN");
	  
      tblUserRole.setTblUser(tblUser);
       
      tblUserRoleDAO.addTblUserRole(tblUserRole);
      tblUserRoleDAO.getAllTblUserRole();
      testRole  = tblUserRole; 
		
		
	}

	@Test
	public void test() {
		assertTrue(tblUserRoleService.doGetAllTblUserRole()!=null);
		System.out.println("inserted id is = "+testRole.getId());
	}

	
	
	
	
	
	
	
	@After
    public void afterTestFileService(){
		tblUserRoleDAO.deleteTblUserRoleByUserName("hacker");
	}

	
}
