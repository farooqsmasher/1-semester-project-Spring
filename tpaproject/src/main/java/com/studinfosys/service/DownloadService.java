package com.studinfosys.service;

import java.util.List;

import com.studinfosys.entity.Download;
import com.studinfosys.entity.UploadFile;

public interface DownloadService {
	public void doAddDownload(Download download);

	public List<Download> doGetAllDownloads();

	public List<Download> doGetAllDownloadsByUser(String userName);

	public Download doGetDownloadById(int id);
}
