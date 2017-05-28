package com.shakul.myd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "id_sequence")
	@SequenceGenerator(name = "id_sequence" , sequenceName = "ID_SEQ")
	private String id;
	
	@Column(name="TYPE", length=15, unique=true, nullable=false)
	private String strUserType = UserProfileType.USER.getUserProfileType();

	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStrUserType() {
		return strUserType;
	}

	public void setStrUserType(String strUserType) {
		this.strUserType = strUserType;
	}
/*
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((strUserType == null) ? 0 : strUserType.hashCode());
        return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (id != other.id)
            return false;
        if (strUserType == null) {
            if (other.strUserType != null)
                return false;
        } else if (!strUserType.equals(other.strUserType))
            return false;
        return true;
    }
	
	@Override
    public String toString() {
        return "UserProfile [id=" + id + ",  strUserType=" + strUserType  + "]";
    }
*/	
}
