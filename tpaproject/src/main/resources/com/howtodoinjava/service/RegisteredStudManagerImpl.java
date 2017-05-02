package com.howtodoinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.dao.RegisteredStudDAO;
import com.howtodoinjava.entity.RegisteredStudEntity;

@Service
public class RegisteredStudManagerImpl implements RegisteredStudManager {
	
	@Autowired
    private RegisteredStudDAO registeredStudDAO;

	@Override
	@Transactional
	public void addRegisteredStud(RegisteredStudEntity registeredStud) {
		//Integer applNo=null;
		registeredStudDAO.addRegisteredStud(registeredStud);
	//return applNo;
	}
		public void setRegisteredStudDAO(RegisteredStudDAO registeredStudDAO) {
		this.registeredStudDAO = registeredStudDAO;
	}
}
