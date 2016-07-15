package com.stee.erp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {
	
	private static DBUtils dbUtils;
	
	@Autowired
	private  BasicDataSource dataSource;

	@PostConstruct
	public void init() {
		dbUtils=this;
		dbUtils.dataSource=this.dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return dbUtils.dataSource.getConnection();
	}
	
}
