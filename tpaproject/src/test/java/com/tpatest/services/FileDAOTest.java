package com.tpatest.services;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.studinfosys.dao.FileDAO;
import com.studinfosys.entity.TblUser;
import com.studinfosys.entity.UploadFile;
import com.studinfosys.service.FileService;
import com.studinfosys.service.TblUserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@WebAppConfiguration
public class FileDAOTest {
	@Autowired
	TblUserService tblUserService;
	@Autowired
	FileService fileService;

	@Autowired
	FileDAO fileDAO;
	
	UploadFile mainFile;
	
	
	@Before // Setting data to upload file
    public void beforeTestFileService(){
    UploadFile uploadFile = new UploadFile();
	uploadFile.setStatus("ok");
    uploadFile.setName("testfile");
    uploadFile.setDescription("login.txt");
    uploadFile.setUploadDate(new Date());
    
    fileDAO.addFile(uploadFile);
    mainFile = uploadFile;
    }

	
    
    
	@Test  // Testing Get file By ID Method && printing uploaded file Details
    public void testFileService(){
		assertTrue(fileDAO.getFileById(mainFile.getId())!=null);
    	System.out.println("inserted id is = "+mainFile.getId());
    	
    	System.out.println("inserted id is = "+mainFile.getStatus());
    	System.out.println("inserted id is = "+mainFile.getDescription());
    	System.out.println("inserted id is = "+mainFile.getUploadDate());
    }
	
	 @Test //test case to get request file or not
		public void testRequestedOrNotu(){
	    	assertTrue(fileDAO.getAllFilesByUser("farooq")!=null);
			
		}
	
	
	   @Test// Test case to get file by userName
	    public void testcaseforfilesbyuserName(){
	    	assertTrue(fileDAO.getNotVerfiedFilesByUser("farooq")!=null);
	    }
	 
	
       @Test // Testing for not Veried Fiels
   public void testnottverified(){
    	
    	assertTrue(fileDAO.getRequestedOrNotVerifiedFiles()!=null);
    }
    
      @Test //Testing for Requested files
    public void testforRequestedfiles(){
    	
    	
    	assertTrue(fileDAO.getVerfiedFiles()!=null);
     }
    
    @Test //Testing to get All files
    public void testtogetALLfiles(){
    	assertTrue(fileDAO.getAllFiles()!=null);
    	
    }
    
    @Test //test case to get request file or not
	public void testRequestedOrNot(){
    	assertTrue(fileDAO.getRequestedOrNotVerifiedFiles()!=null);
		
	}
    @After
    public void afterTestFileService(){
		
		fileDAO.deleteFile(mainFile);
	}


}
