package com.studinfosys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studinfosys.entity.TblUser;

@Repository
public class TblUserDAOImpl implements TblUserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addTblUser(TblUser tblUser) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(tblUser);
	}

	@Transactional
	public List<TblUser> getAllTblUser() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from TblUser").list();
	}

	@Transactional
	public TblUser getTblUserByUserName(String userName) {
		List<TblUser> tblUserList = this.sessionFactory.getCurrentSession().createQuery("from TblUser where username='"+userName+"'").list();
		for(TblUser tblUser:tblUserList){
			return tblUser;
		}
		return null;
	
	}

	@Transactional
	public void deleteTblUserByUserName(String userName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete TblUser where username='"+userName+"'");
		query.executeUpdate();
	}

}
