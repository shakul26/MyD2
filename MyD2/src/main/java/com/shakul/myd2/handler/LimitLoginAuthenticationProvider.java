package com.shakul.myd2.handler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.shakul.myd2.dao.UserDetailsLoginAttemptDao;
import com.shakul.myd2.model.User;


@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	UserDetailsLoginAttemptDao userDetailsLoginAttemptDao;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		System.out.println("Setting super.setUserDetailsService(userDetailsService);");
		super.setUserDetailsService(userDetailsService);
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException{
		
		try {
			System.out.println(" Starting authentication process : handler : LimitLoginAuthenticationProvider");
			Authentication auth = super.authenticate(authentication);
			System.out.println("calling method resetting failedAttempts since athentication was successful!!");
			userDetailsLoginAttemptDao.resetFailAttempts(authentication.getName());
			
			return auth;
		} catch (BadCredentialsException e) {
		
			
			System.out.println("handler : LimitLoginAuthenticationProvider: catch : BadCredentialsException");
			//invalid login, update to user attempts
			System.out.println("handler : LimitLoginAuthenticationProvider : updating failed attempts");
			userDetailsLoginAttemptDao.updateFailAttempts(authentication.getName());
			System.out.println("chcking conmtrol reaches here");
			throw e;
			
			}
		catch (LockedException ex) {
				
			// this user is locked
			System.out.println("LimitLoginAuthenticationProvider : Athenticate() : LockedException is thrown :User is locked due to max unsuccessful attempt!!");
			String error = "";
			User objUser =  userDetailsLoginAttemptDao.getUser(authentication.getName());
			if(objUser.getIntFailedAuthAttempt()!=0)
			{
				Date lastAttempts =  objUser.getDtLastFailedAuthAttemptTime();
				error = "User account is locked! <br><br>Username : "
                        + authentication.getName() + "<br>Last Attempts : " + lastAttempts;
				System.out.println("LOCKED EXCPETION : "+ error);
		}else{
			System.out.println("check");
			error =ex.getMessage();
			}
			
			throw new LockedException(error);
		}
			
	}
		}



