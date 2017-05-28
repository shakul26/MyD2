package com.shakul.myd2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	/*@GenericGenerator(name="seq_user_id", strategy = "com.shakul.myd2.util.MyD2UserIdGenerator")
	@GeneratedValue(generator = "seq_user_id")*/
	private String r_object_id;
	
	@Column(name ="USER_LOGIN_ID", unique=true, nullable=false)
	private String strUserLoginId;
	
	@Column(name="USER_PASSWORD", nullable=false)
	private String strPassword;
	
	@Column(name="USER_FIRST_NAME", nullable=false)
	private String strUserFirstName;
	
	@Column(name="USER_LAST_NAME", nullable=false)
	private String strUserLastName;
	
	@Column(name="USER_NAME")
	private String strUserName;
	
	 @Column(name="USER_EMAIL", nullable=false)
	 private String strUserEmail;
	 
	 @Column(name="USER_STATE", nullable=false)
	 private String strUserState=UserState.ACTIVE.getUserState();
	 
	 @Column(name="failed_auth_attempt")
	 private int intFailedAuthAttempt;
	 
	 @Column(name = "last_failed_auth_attempt_time")
	 private Date dtLastFailedAuthAttemptTime;
	 @Column(name="last_login_time")
	 private Date dtLast_login_time;
	 
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name="USERS_USER_PROFILE",
			 	joinColumns = {@JoinColumn(name = "USER_ID")},
			 	inverseJoinColumns = {@JoinColumn (name = "USER_PROFILE_ID")})
	 private Set<UserProfile> setUserProfiles = new HashSet<UserProfile>();
	 
	 @Column(name="USER_ACCOUNT_NOT_LOCKED")
	 private boolean blnAccountNotLocked;
	 
	 
	 
	 


	public String getR_object_id() {
		return r_object_id;
	}

	public void setR_object_id(String r_object_id) {
		this.r_object_id = r_object_id;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public Date getDtLast_login_time() {
		return dtLast_login_time;
	}

	public void setDtLast_login_time(Date dtLast_login_time) {
		this.dtLast_login_time = dtLast_login_time;
	}

	public int getIntFailedAuthAttempt() {
		return intFailedAuthAttempt;
	}

	public void setIntFailedAuthAttempt(int intFailedAuthAttempt) {
		this.intFailedAuthAttempt = intFailedAuthAttempt;
	}

	public Date getDtLastFailedAuthAttemptTime() {
		return dtLastFailedAuthAttemptTime;
	}

	public void setDtLastFailedAuthAttemptTime(Date dtLastFailedAuthAttemptTime) {
		this.dtLastFailedAuthAttemptTime = dtLastFailedAuthAttemptTime;
	}

	public boolean isBlnAccountNotLocked() {
		return blnAccountNotLocked;
	}

	public void setBlnAccountNotLocked(boolean blnAccountNotLocked) {
		this.blnAccountNotLocked = blnAccountNotLocked;
	}



	public String getStrUserLoginId() {
		return strUserLoginId;
	}

	public void setStrUserLoginId(String strUserLoginId) {
		this.strUserLoginId = strUserLoginId;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrUserFirstName() {
		return strUserFirstName;
	}

	public void setStrUserFirstName(String strUserFirstName) {
		this.strUserFirstName = strUserFirstName;
	}

	public String getStrUserLastName() {
		return strUserLastName;
	}

	public void setStrUserLastName(String strUserLastName) {
		this.strUserLastName = strUserLastName;
	}

	public String getStrUserEmail() {
		return strUserEmail;
	}

	public void setStrUserEmail(String strUserEmail) {
		this.strUserEmail = strUserEmail;
	}

	public String getStrUserState() {
		return strUserState;
	}

	public void setStrUserState(String strUserState) {
		this.strUserState = strUserState;
	}

	public Set<UserProfile> getSetUserProfiles() {
		return setUserProfiles;
	}

	public void setSetUserProfiles(Set<UserProfile> setUserProfiles) {
		this.setUserProfiles = setUserProfiles;
	}
	 
	 /*
	  @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + r;
	        result = prime * result + ((strUserLoginId == null) ? 0 : strUserLoginId.hashCode());
	        return result;
	    }
	  
	  @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof User))
	            return false;
	        User other = (User) obj;
	        if (r_obje t != other.id)
	            return false;
	        if (strUserLoginId == null) {
	            if (other.strUserLoginId != null)
	                return false;
	        } else if (!strUserLoginId.equals(other.strUserLoginId))
	            return false;
	        return true;
	    }
	  
	  @Override
	    public String toString() {
	        return "User [id=" + id + ", strUserLoginId=" + strUserLoginId + ", strPassword=" + strPassword
	                + ", strUserFirstName=" + strUserFirstName + ", strUserLasttName=" + strUserLastName
	                + ", strUserEmail=" + strUserEmail + ", strUserState=" + strUserState + ", setUserProfiles=" + setUserProfiles +"]";
	    }
	 */
}
