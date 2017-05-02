package com.studinfosys.service;

import java.util.List;

import com.studinfosys.entity.UploadFile;

public interface FileService {
	public void doAddFile(UploadFile file);
	public void deleteFile(UploadFile file);
	public List<UploadFile> doGetAllFiles();
	public List<UploadFile> doGetVerifiedFiles();
	public List<UploadFile> doGetNotVerifiedFiles();
	public List<UploadFile> doGetRequestedFiles();
	public List<UploadFile> doGetAllFilesByUser(String userName);
	public List<UploadFile> doGetVerfiedFilesByUser(String userName);
	public List<UploadFile> doGetNotVerfiedFilesByUser(String userName);
	public List<UploadFile> doGetRequestedFilesByUser(String userName);
	public List<UploadFile> doGetRequestedOrNotVerifiedFiles();
	public UploadFile doGetFileById(int id);
}
