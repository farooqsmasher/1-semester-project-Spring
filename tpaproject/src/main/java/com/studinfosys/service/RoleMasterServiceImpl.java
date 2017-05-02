package com.studinfosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studinfosys.dao.RoleMasterDAO;
import com.studinfosys.entity.RoleMaster;
@Service
public class RoleMasterServiceImpl implements RoleMasterService {

	@Autowired
	RoleMasterDAO roleMasterDAO;
	
	
	public List<RoleMaster> doGetAllRoleMaster() {
		// TODO Auto-generated method stub
		return roleMasterDAO.getAllRoleMaster();
	}

}
