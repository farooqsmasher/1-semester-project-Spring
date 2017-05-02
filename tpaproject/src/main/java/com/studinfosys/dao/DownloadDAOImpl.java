package com.studinfosys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studinfosys.entity.Download;
import com.studinfosys.entity.UploadFile;

@Repository
public class DownloadDAOImpl implements DownloadDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addDownload(Download download) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(download);
	}

	@Transactional
	public List<Download> getAllDownloads() {
		return this.sessionFactory.getCurrentSession().createQuery("from Download").list();
	}


	@Transactional
	public List<Download> getAllDownloadsByUser(String userName) {
		return this.sessionFactory.getCurrentSession().createQuery("from Download f where f.tblUser.username='"+userName+"'").list();
	}
	

	@Transactional
	public Download getDownloadById(int id) {
		List<Download> list = this.sessionFactory.getCurrentSession().createQuery("from Download f where f.id="+id).list();
		for(Download download : list){
			return download;
		}
		return null;
	}

	
	
}
