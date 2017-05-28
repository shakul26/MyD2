package com.shakul.myd2.model;

public enum UserProfileType {
	USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
     
	private String strUserProfileType;

	private UserProfileType(String strUserProfileType) {
		this.strUserProfileType = strUserProfileType;
	}
	
	public String getUserProfileType(){
        return strUserProfileType;
    }
}
