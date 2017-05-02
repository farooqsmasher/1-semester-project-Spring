package com.studinfosys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studinfosys.entity.UploadFile;

@Repository
public class FileDAOImpl implements FileDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addFile(UploadFile file) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(file);
	}

	@Transactional
	public List<UploadFile> getAllFiles() {
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile").list();
	}

	@Transactional
	public List<UploadFile> getVerfiedFiles() {
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile where status='ok'").list();
	}
	@Transactional
	public List<UploadFile> getNotVerfiedFiles() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile where status='not_verified'").list();
	}
	
	@Transactional
	public List<UploadFile> getRequestedFiles() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile where status='requested'").list();
	}

	@Transactional
	public List<UploadFile> getAllFilesByUser(String userName) {
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile f where f.tblUser.username='"+userName+"'").list();
	}
	
	@Transactional
	public List<UploadFile> getRequestedOrNotVerifiedFiles(){
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile where status='requested' or status='not_verified'").list();
	}

	
	@Transactional
	public List<UploadFile> getVerfiedFilesByUser(String userName) {
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile f where f.status='ok' and f.tblUser.username='"+userName+"'").list();
	}
	
	
	@Transactional
	public List<UploadFile> getNotVerfiedFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile f where f.status='not_verified' and f.tblUser.username='"+userName+"'").list();
	}
	
	
	@Transactional
	public List<UploadFile> getRequestedFilesByUser(String userName) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from UploadFile f where f.status='requested' and f.tblUser.username='"+userName+"'").list();
	}

	@Transactional
	public UploadFile getFileById(int id) {
		List<UploadFile> list = this.sessionFactory.getCurrentSession().createQuery("from UploadFile f where f.id="+id).list();
		for(UploadFile uploadFile : list){
			return uploadFile;
		}
		return null;
	}

	@Transactional
	public void deleteFile(UploadFile file) {
		this.sessionFactory.getCurrentSession().delete(file);	
	}
	
	
}
