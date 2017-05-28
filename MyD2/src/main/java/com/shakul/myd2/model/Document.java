package com.shakul.myd2.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dm_document")
@AttributeOverrides({
		@AttributeOverride(name="strSObjectName", column=@Column(name="object_name")),
		@AttributeOverride(name="strSTitle", column=@Column(name="title"))
})
public class Document extends SysObject{

	public Document(){
		
	}
	public Document(String strSObjectName, String strSTitle) {
		super(strSObjectName, strSTitle);

		
	}
	

	
}
