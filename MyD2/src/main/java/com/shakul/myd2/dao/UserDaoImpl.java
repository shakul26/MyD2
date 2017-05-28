package com.shakul.myd2.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shakul.myd2.model.User;
import com.shakul.myd2.util.GenerateId;
import com.shakul.myd2.util.PropertiesCache;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	@Override
	public User findById(String r_object_id) {
		// TODO Auto-generated method stub
		return getByKey(r_object_id);
	}

	@Override
	public User findByUserLoginId(String strUserLoginId) {
		
		Criteria cr = createEntityCriteria();
		cr.add(Restrictions.eq("strUserLoginId", strUserLoginId));
		return (User) cr.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		
		persist(user);
	}

	@Override
	public void setDafaultValue(User user) {
		GenerateId.setRObjectId(user);
		user.setBlnAccountNotLocked(Boolean.valueOf(PropertiesCache.getInstance().getProperty("user_account_not_locked_true")));
		user.setStrPassword(PropertiesCache.getInstance().getProperty("default_user_password"));
		user.setStrUserName(user.getStrUserLastName()+PropertiesCache.getInstance().getProperty("user_name_separater")+user.getStrUserFirstName());
		user.setStrUserState(PropertiesCache.getInstance().getProperty("default_user_state"));
		user.setIntFailedAuthAttempt(Integer.valueOf(PropertiesCache.getInstance().getProperty("default_user_failed_attempt")));
		
		
		
	}

	@Override
	public User getUserNameList(User searchUser) {
		
		System.out.println("userName : " +searchUser.getStrUserName());
		System.out.println("userName : " +searchUser.getStrUserLoginId());
		System.out.println("userName : " +searchUser.getStrUserEmail());
		
		if(searchUser.getStrUserName()!=null && !searchUser.getStrUserName().isEmpty() ){
			Criteria cr = createEntityCriteria();
			cr.add(Restrictions.eq("strUserName", searchUser.getStrUserName()));
			System.out.println("result fetched");
			return (User) cr.uniqueResult();
		}
		if(searchUser.getStrUserLoginId()!=null && !searchUser.getStrUserLoginId().isEmpty()){
			Criteria cr = createEntityCriteria();
			cr.add(Restrictions.eq("strUserLoginId", searchUser.getStrUserLoginId()));
			return (User) cr.uniqueResult();
		}
		if(searchUser.getStrUserEmail() !=null && !searchUser.getStrUserEmail().isEmpty()){
			Criteria cr = createEntityCriteria();
			cr.add(Restrictions.eq("strUserEmail", searchUser.getStrUserEmail()));
			return (User) cr.uniqueResult();
		}
		
		return null;
	}

}
