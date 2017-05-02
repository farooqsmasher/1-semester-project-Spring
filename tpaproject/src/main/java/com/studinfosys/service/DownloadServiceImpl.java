package com.studinfosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studinfosys.dao.DownloadDAO;
import com.studinfosys.entity.Download;
@Service
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	DownloadDAO downloadDAO;
	
	public void doAddDownload(Download download) {		
		downloadDAO.addDownload(download);
	}

	public List<Download> doGetAllDownloads() {
		// TODO Auto-generated method stub
		return downloadDAO.getAllDownloads();
	}

	public List<Download> doGetAllDownloadsByUser(String userName) {
		// TODO Auto-generated method stub
		return downloadDAO.getAllDownloadsByUser(userName);
	}
	public Download doGetDownloadById(int id) {
		// TODO Auto-generated method stub
		return downloadDAO.getDownloadById(id);
	}

	
}
