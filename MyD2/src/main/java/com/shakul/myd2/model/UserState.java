package com.shakul.myd2.model;

public enum UserState {

	ACTIVE("Active"),
	INACTIVE("Inactive"),
	DELETED("Deleted"),
	LOCKED("Locked");
	
	private String strUserState;

	private UserState(final String strUserState){
        this.strUserState = strUserState;
    }
	
	public String getUserState(){
        return this.strUserState;
    }
 
	 @Override
	    public String toString(){
	        return this.strUserState;
	    }
	 
	    public String getName(){
	        return this.getName();
	    }
	
}
