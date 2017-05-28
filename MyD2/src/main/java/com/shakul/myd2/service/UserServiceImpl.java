package com.shakul.myd2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shakul.myd2.dao.UserDao;
import com.shakul.myd2.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User findById(String r_object_id) {
		// TODO Auto-generated method stub
		return dao.findById(r_object_id);
	}

	@Override
	public User findByUserLoginId(String strUserLoginId) {
		// TODO Auto-generated method stub
		return dao.findByUserLoginId(strUserLoginId);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		dao.saveUser(user);
	}

	@Override
	public void setDefaultValue(User user) {

		dao.setDafaultValue(user);
	}

	@Override
	public User getUserNameList(User searchUser) {
		
		
		return dao.getUserNameList(searchUser);
	}

}
