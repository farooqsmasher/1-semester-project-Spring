package com.studinfosys.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.studinfosys.dao.TblUserDAO;
import com.studinfosys.dao.TblUserRoleDAO;
import com.studinfosys.entity.RoleMaster;
import com.studinfosys.entity.TblUser;
import com.studinfosys.entity.TblUserRole;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@WebAppConfiguration

public class TblUserDAOTest {
	
	@Autowired
	TblUserService  tblUserService;
	
	@Autowired
	TblUserRoleService tblUserRoleService;
	
	@Autowired
	TblUserRoleDAO tblUserRoleDAO;
	
	@Autowired
	TblUserDAO tblUserDAO;
	TblUser testuser;
	
	

	@Before //Inserting the details of the user
	public void Tbluserservicetest() {
		TblUser tblUser = new TblUser();
		TblUserRole tblUserRole = new TblUserRole();
		RoleMaster roleMaster = new RoleMaster();
		tblUser.setUsername("hacker");
		tblUser.setPassword("1234");
		tblUser.setEmail("fff@outlook.com");
		tblUser.setFirstName("mohammed");
		tblUser.setDesignation("software Developer");
		tblUser.setLastName("Rasheed");
		tblUser.setEnabled(1);
		
		roleMaster.setRoleId("ROLE_USER");
        tblUserRole.setRoleMaster(roleMaster);
		tblUserRole.setTblUser(tblUser);
		tblUserDAO.addTblUser(tblUser);
		
		testuser = tblUser;
		}

	@Test
	public void Tbluserservice() {
		assertTrue(tblUserService.doGetTblUserByUserName("hacker")!=null);
		System.out.println("inserted id is = "+testuser.getUsername());
		System.out.println("inserted id is = "+testuser.getEmail());
		System.out.println("inserted id is = "+testuser.getEnabled());
		System.out.println("inserted id is = "+testuser.getDesignation());
		System.out.println("inserted id is = "+testuser.getFirstName());
		System.out.println("inserted id is = "+testuser.getLastName());
		}

	@Test
	public void Tblusertestlist(){
		assertTrue(tblUserService.doGetAllTblUser()!=null);
	}
	@Test
	public void Tblusertesttolistalltbluserroles(){
		assertTrue(tblUserRoleService.doGetAllTblUserRole()!=null);
	}
	
	@Test
	public void Tblusertesttolistalltbluserrol(){
		assertTrue(tblUserRoleService.doGetTblUserRoleByUserName("test")!=null);
	}
	
	@After
	public void TbluserServiceAfter(){
		tblUserDAO.deleteTblUserByUserName("hacker");
	
		}
	
	
}
