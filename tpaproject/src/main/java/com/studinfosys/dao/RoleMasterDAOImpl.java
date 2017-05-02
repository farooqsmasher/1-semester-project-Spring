package com.studinfosys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studinfosys.entity.RoleMaster;
@Repository
public class RoleMasterDAOImpl implements RoleMasterDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public List<RoleMaster> getAllRoleMaster() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from RoleMaster").list();
	}

}
