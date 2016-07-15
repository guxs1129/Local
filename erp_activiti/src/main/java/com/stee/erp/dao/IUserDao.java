package com.stee.erp.dao;

import com.stee.erp.model.User;

public interface IUserDao {
	public User findByNameAndPassword(User user) throws Exception;

}
