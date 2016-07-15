package com.stee.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.erp.dao.IUserDao;
import com.stee.erp.model.User;
import com.stee.erp.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userdao;
	@Override
	public User findByNameAndPassword(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.findByNameAndPassword(user);
	}

}
