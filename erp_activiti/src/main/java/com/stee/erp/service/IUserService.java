package com.stee.erp.service;

import com.stee.erp.model.User;

public interface IUserService {
	public User findByNameAndPassword(User user) throws Exception;

}
