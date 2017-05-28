package com.shakul.myd2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shakul.myd2.model.User;
import com.shakul.myd2.model.UserProfile;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String strUserLoginId)
			throws UsernameNotFoundException {
	
		System.out.println("CustomUserDetailsService : loadUserByUsername() : started");
		User user = userService.findByUserLoginId(strUserLoginId);
		System.out.println("User : " + user);
		if(user == null){
			System.out.println("User Not Found!!");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getStrUserLoginId(), user.getStrPassword(), 
					isUserEnabled(user),true,true,isUserNotLocked(user),getGrantedAuthorities(user));
		

	}
	
	private boolean isUserEnabled(User user){
		if(user.getStrUserState().equals("Active"))
			return true;
		else 
			return false;
	}
	
	private boolean isUserNotLocked(User user) {
		
		if(user.isBlnAccountNotLocked()){
			return true;
		}
		else
		return false;
	}


	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (UserProfile userProfile : user.getSetUserProfiles()) {
			System.out.println("UserProfile : " +userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getStrUserType()));
		}
		System.out.println("authorities : " +authorities);
		return authorities;
		
	}

}
