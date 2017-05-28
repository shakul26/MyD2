package com.shakul.myd2.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import java.util.Random;



import com.shakul.myd2.model.User;

public  class GenerateId {

	private static Map<Object, String> mpObjectInitDigit = new HashMap<Object, String>();
	
	public void initMap(){
		mpObjectInitDigit.put(User.class, PropertiesCache.getInstance().getProperty("init_digit_user_object_01"));
	}
	
	
	public static void setRObjectId(Object obj){
		
		
		
		if(obj instanceof User)
		{
			System.out.println("Object Is User");
			((User) obj).setR_object_id(PropertiesCache.getInstance().getProperty("init_digit_user_object_01")+getBigNumber().toString());
		}
		
	
	}
	
	public static BigInteger getBigNumber(){
		BigInteger randomUserId = new BigInteger(256, new Random());
		
		return randomUserId;
	}
}
