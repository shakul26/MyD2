package com.shakul.myd2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Repository;

import com.shakul.myd2.model.User;

import com.shakul.myd2.util.PropertiesCache;

@Repository
public class UserDetailsLoginAttemptDaoImpl extends JdbcDaoSupport implements UserDetailsLoginAttemptDao{

	private static final String strSqlUsersUpdateLocked = "UPDATE USERS SET USER_ACCOUNT_NOT_LOCKED = ? WHERE USER_LOGIN_ID = ?";
	private static final String strSqlUsersCount = "SELECT count(*) FROM USERS WHERE USER_LOGIN_ID = ?";
	private static final String strSqlUserGet = "SELECT * FROM USERS WHERE USER_LOGIN_ID = ?";
	private static final String strSqlUsersUpdateFirstFailedAttempt = "UPDATE USERS SET failed_auth_attempt = 1, last_failed_auth_attempt_time = ? WHERE USER_LOGIN_ID = ?";
	private static final String strSqlUserUpdateFailAttempts = "UPDATE USERS SET failed_auth_attempt = failed_auth_attempt + 1, last_failed_auth_attempt_time = ? WHERE USER_LOGIN_ID = ?";
	private static final String strSqlUserResetFailAttempts = "UPDATE USERS SET failed_auth_attempt = 0,last_login_time=? WHERE USER_LOGIN_ID = ?";
	
	private static final int MAX_ATTEMPTS = Integer.valueOf(PropertiesCache.getInstance().getProperty("lock_MAX_ATTEMPTS"));
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	@Override
	public void updateFailAttempts(String strUserLoginId) {
		
		System.out.println("UserDetailsLoginAttemptDaoImpl : fetching userAttempts from DB");
		  User objeUser = getUser(strUserLoginId);
	// if user does not exist do nothing	
	 if(objeUser!= null){	  
	 	if(objeUser.getIntFailedAuthAttempt() <= 0){
			System.out.println("UserDetailsLoginAttemptDaoImpl : user attempts is "+objeUser.getIntFailedAuthAttempt());
			// to make sure user exists in DB and he is entering wrong password
			if(isUserExists(strUserLoginId)){
				// since he is entering the wrong password first time. so initial value for attempt is 1
				System.out.println("UserDetailsLoginAttemptDaoImpl : user exixts in DB but no failed attempts.");
				System.out.println("updating failed attepts in DB");
				getJdbcTemplate().update(strSqlUsersUpdateFirstFailedAttempt,new Object[]{new Date(),strUserLoginId });
			}
		} // user has already attempted wrong authentication at least once
	 else{
			
			System.out.println("UserDetailsLoginAttemptDaoImpl : user attempts is "+objeUser.getIntFailedAuthAttempt());
			// check is necessary in case user attempted wrong authentication once and then after that user was removed from USERS table as business need. to check if user exists
			if(isUserExists(strUserLoginId)){
				System.out.println("UserDetailsLoginAttemptDaoImpl : user exists : increasing failed attempt counter");
				getJdbcTemplate().update(strSqlUserUpdateFailAttempts, new Object[]{new Date(), strUserLoginId});
			}
			
			if(objeUser.getIntFailedAuthAttempt() +1 >= MAX_ATTEMPTS){
				
				System.out.println("UserDetailsLoginAttemptDaoImpl : user attempts is more than max limit");
				System.out.println("UserDetailsLoginAttemptDaoImpl : setting user account not locked status to false");
				getJdbcTemplate().update(strSqlUsersUpdateLocked, new Object[]{false , strUserLoginId});
				System.out.println("UserDetailsLoginAttemptDaoImpl :user account locked inside now!!");
				System.out.println("UserDetailsLoginAttemptDaoImpl : throwing locked exception now..");
				// throw  excstrUserLoginIdtion
				throw new LockedException(PropertiesCache.getInstance().getProperty("exception_msg_account_locked"));
			}
		}
	 }
		
	}
	@Override
	public void resetFailAttempts(String strUserLoginId) {
		
		getJdbcTemplate().update(strSqlUserResetFailAttempts, new Object[]{new Date(),strUserLoginId});
		
	}
	@Override
	public User getUser(String strUserLoginId) {
		
		try {
			System.out.println("Fetchin user object ...");
			System.out.println("strUserLoginId : "+ strUserLoginId);
			User objUser =  getJdbcTemplate().queryForObject(strSqlUserGet, new Object[]{strUserLoginId}, new RowMapper<User>(){
				
				public User mapRow(ResultSet rs, int rowNum) throws SQLException{
					
					User objU = new User();
					
					objU.setStrUserLoginId(rs.getString(PropertiesCache.getInstance().getProperty("qry_param_user_login_id")));
					
					objU.setIntFailedAuthAttempt(rs.getInt(PropertiesCache.getInstance().getProperty("qry_param_attempts")));
					objU.setDtLastFailedAuthAttemptTime(rs.getDate(PropertiesCache.getInstance().getProperty("qry_param_last_modified")));
					
					return objU;
				}
			});
			
			System.out.println("after fetching : failed auth attempt : " + objUser.getIntFailedAuthAttempt());
			return objUser;
			
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			System.out.println("First failed attempt inside catch");
			return null;
		}


	}

	
	
	private boolean isUserExists(String strUserLoginId){
		boolean flag =false;
		
		System.out.println("Checking user existence!!");
		int count = getJdbcTemplate().queryForObject(strSqlUsersCount, new Object[]{strUserLoginId},Integer.class);
		 	if(count > 0){
		 		flag = true;
		 	}
		 	
		 	if(flag)
		 		System.out.println("User exists!!");
		return flag;
	}

}
