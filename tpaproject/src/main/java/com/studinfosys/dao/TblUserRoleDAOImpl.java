package com.studinfosys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studinfosys.entity.TblUserRole;

@Repository
public class TblUserRoleDAOImpl implements TblUserRoleDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public void addTblUserRole(TblUserRole tblUserRole) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(tblUserRole);

	}

	@Transactional
	public List<TblUserRole> getAllTblUserRole() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from TblUserRole").list();
	}

	@Transactional
	public List<TblUserRole> getTblUserRoleByUserName(String userName) {
		List<TblUserRole> tblUserRoleList = this.sessionFactory.getCurrentSession().createQuery("from TblUserRole where tblUser.username="+userName).list();
		return tblUserRoleList;

	}

	@Transactional
	public void deleteTblUserRoleByUserName(String userName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete TblUserRole where tblUser.username="+userName);
		query.executeUpdate();
	}

}
