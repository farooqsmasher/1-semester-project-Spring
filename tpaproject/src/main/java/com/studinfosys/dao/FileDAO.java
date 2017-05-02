package com.studinfosys.dao;

import java.util.List;

import com.studinfosys.entity.UploadFile;

public interface FileDAO {
	public void addFile(UploadFile file);
	public void deleteFile(UploadFile file);
	public List<UploadFile> getAllFiles();
	public List<UploadFile> getVerfiedFiles();
	public List<UploadFile> getNotVerfiedFiles();
	public List<UploadFile> getRequestedFiles();
	public List<UploadFile> getAllFilesByUser(String userName);
	public List<UploadFile> getVerfiedFilesByUser(String userName);
	public List<UploadFile> getNotVerfiedFilesByUser(String userName);
	public List<UploadFile> getRequestedFilesByUser(String userName);
	public List<UploadFile> getRequestedOrNotVerifiedFiles();
	public UploadFile getFileById(int id);
}
	