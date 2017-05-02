package com.studinfosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studinfosys.dao.FileDAO;
import com.studinfosys.entity.UploadFile;
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileDAO fileDAO;
	
	public void doAddFile(UploadFile file) {
		
		
		fileDAO.addFile(file);
	}

	public void deleteFile(UploadFile file) {
		// TODO Auto-generated method stub
		 fileDAO.deleteFile(file);
	}
	
	public List<UploadFile> doGetAllFiles() {
		// TODO Auto-generated method stub
		return fileDAO.getAllFiles();
	}

	public List<UploadFile> doGetVerifiedFiles() {
		// TODO Auto-generated method stub
		return fileDAO.getVerfiedFiles();
	}

	public List<UploadFile> doGetNotVerifiedFiles() {
		// TODO Auto-generated method stub
		return fileDAO.getNotVerfiedFiles();
	}

	public List<UploadFile> doGetRequestedFiles() {
		// TODO Auto-generated method stub
		return fileDAO.getRequestedFiles();
	}
	
	public List<UploadFile> doGetRequestedOrNotVerifiedFiles(){
		return fileDAO.getRequestedOrNotVerifiedFiles();
	}

	public List<UploadFile> doGetAllFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return fileDAO.getAllFilesByUser(userName);
	}

	public List<UploadFile> doGetVerfiedFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return fileDAO.getVerfiedFilesByUser(userName);
	}

	public List<UploadFile> doGetNotVerfiedFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return fileDAO.getNotVerfiedFilesByUser(userName);
	}

	public List<UploadFile> doGetRequestedFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return fileDAO.getRequestedFilesByUser(userName);
	}

	public UploadFile doGetFileById(int id) {
		// TODO Auto-generated method stub
		return fileDAO.getFileById(id);
	}

	

	
}
