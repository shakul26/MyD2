package com.shakul.myd2.dao;

import com.shakul.myd2.model.User;


public interface UserDetailsLoginAttemptDao {

	
	void updateFailAttempts(String strUserLoginId);
	void resetFailAttempts(String strUserLoginId);
	
	User getUser(String strUserLoginId);
}
