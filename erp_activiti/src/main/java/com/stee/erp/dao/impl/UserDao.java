package com.stee.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;

import com.stee.erp.dao.IUserDao;
import com.stee.erp.exception.UserException;
import com.stee.erp.model.User;
import com.stee.erp.util.DBUtils;

@Repository
public class UserDao implements IUserDao {
	

	@Override
	public User findByNameAndPassword(User user) throws UserException, Exception {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			String sql="select username,password from erp_user where username=? and password=?";
			connection=DBUtils.getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, user.getUsername());
			pStatement.setString(2, user.getPassword());
			ResultSet rs=pStatement.executeQuery();
			if (rs.next()) {
				User resultUser=new User();
				BeanUtils.setProperty(resultUser, "username", rs.getString(1));
				BeanUtils.setProperty(resultUser, "password", rs.getString(2));
				return resultUser;
			}else {
				throw new UserException(user.getUsername()+" username or password not correct");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
