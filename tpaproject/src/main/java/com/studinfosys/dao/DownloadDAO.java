package com.studinfosys.dao;

import java.util.List;

import com.studinfosys.entity.Download;

public interface DownloadDAO {
	public void addDownload(Download download);
	public List<Download> getAllDownloads();
	public List<Download> getAllDownloadsByUser(String userName);
	public Download getDownloadById(int id);
}
	