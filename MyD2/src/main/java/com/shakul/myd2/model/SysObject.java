package com.shakul.myd2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "dm_sysobject")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SysObject {
	@Id
	@Column(name="r_object_id")
	private String r_object_id; // S
	
	@Column(name = "a_extended _properties")
	private String strRAExtendedProperty; // R
	
	//Indicates if this object is visible to end-users
	@Column(name="a_is_hidden")
	private boolean blnSAIsHidden;//S
	
	//Indicates whether the object is a	template
	@Column(name="a_is_template")
	private boolean blnSAIsTemplate;//S

	/*If the object is the root version of a
	version tree, deleting the object sets
	this property to TRUE.*/
	@Column(name="i_is_deleted")
	private boolean blnSIIsDeleted;//S
	
	@Column(name="object_name")
	private String strSObjectName;
	
	/*
	 *  Contains the date and time when a
		Getfile or Print method last accessed
		this object.
	 * */
	@Column(name="r_access_date")
	private Date dtSRAccessDate;

	/*
	 *  Date the object was created. 
	 * */
	@Column(name="r_creation_date")
	private Date dtSRCreationDate;
	

	/*
	 *  Date the object was last modified. 
	 * */
	@Column(name="r_modify_date")
	private Date dtSRModifyDate;
	
	/*Name of the user who made the last
		modification.*/
	@Column(name="r_modifier")
	private String strRRmodifier;

	/*
	 * The type of the object, for example,
		dm_sysobject or dm_document, set
		when the object is created.
	 * */
	@Column(name="r_object_type")
	private String strSRObjectType;
	
	@Column(name="subject")
	private String strSSubject;
	
	@Column(name="title")
	private String strSTitle;
	
	@Column(name="i_folder_id")
	private String strSIFolderId;
	
	/*
	  
	 File format of the object’s content.
	 For some system-created renditions,
	 Content Server sets this value to
	 dm_internal
	 */
	
	@Column(name="a_content_type")
	private String strSAContentType;
	
	/*
	 * Indicates whether the document is
	 	marked for full-text indexing. The
		default is TRUE
	 * */
	@Column(name = "a_full_text")
	private boolean blnSAFullText;
	
	@Column(name="acl_name")
	private String strSAclName;
	
	@Column(name="r_lock_machine")
	private String strSRLlockMachine;
	
	/*
	 * Object ID of the object’s parent version.
	 * */
	@Column(name="i_antecedent_id")
	private String strSIAntecedentId;
	
	@Column(name="i_chronicle_id")
	private String strSIChronicleId;
	
	/*
	 * Indicates whether the object can be
changed. The default is FALSE.
	 * */
	@Column(name="r_immutable_flag")
	private String blnSRImmutableFlag;
	
	/*
	 * Date that this object was locked
	 */
	@Column(name="r_lock_date")
	private String dtSRLockDate;
	
	/*Name of the user who locked the
object.
	 * */
	@Column(name="r_lock_owner")
	private String strSRLockOwner;

	public SysObject(String strSObjectName2, String strSTitle2) {
		
		this.strSObjectName=strSObjectName2;
		this.strSTitle=strSTitle2;
	}

	public String getR_object_id() {
		return r_object_id;
	}

	public void setR_object_id(String r_object_id) {
		this.r_object_id = r_object_id;
	}

	public String getStrRAExtendedProperty() {
		return strRAExtendedProperty;
	}

	public void setStrRAExtendedProperty(String strRAExtendedProperty) {
		this.strRAExtendedProperty = strRAExtendedProperty;
	}

	public boolean isBlnSAIsHidden() {
		return blnSAIsHidden;
	}

	public void setBlnSAIsHidden(boolean blnSAIsHidden) {
		this.blnSAIsHidden = blnSAIsHidden;
	}

	public boolean isBlnSAIsTemplate() {
		return blnSAIsTemplate;
	}

	public void setBlnSAIsTemplate(boolean blnSAIsTemplate) {
		this.blnSAIsTemplate = blnSAIsTemplate;
	}

	public boolean isBlnSIIsDeleted() {
		return blnSIIsDeleted;
	}

	public void setBlnSIIsDeleted(boolean blnSIIsDeleted) {
		this.blnSIIsDeleted = blnSIIsDeleted;
	}

	public String getStrSObjectName() {
		return strSObjectName;
	}

	public void setStrSObjectName(String strSObjectName) {
		this.strSObjectName = strSObjectName;
	}

	public Date getDtSRAccessDate() {
		return dtSRAccessDate;
	}

	public void setDtSRAccessDate(Date dtSRAccessDate) {
		this.dtSRAccessDate = dtSRAccessDate;
	}

	public Date getDtSRCreationDate() {
		return dtSRCreationDate;
	}

	public void setDtSRCreationDate(Date dtSRCreationDate) {
		this.dtSRCreationDate = dtSRCreationDate;
	}

	public Date getDtSRModifyDate() {
		return dtSRModifyDate;
	}

	public void setDtSRModifyDate(Date dtSRModifyDate) {
		this.dtSRModifyDate = dtSRModifyDate;
	}

	public String getStrRRmodifier() {
		return strRRmodifier;
	}

	public void setStrRRmodifier(String strRRmodifier) {
		this.strRRmodifier = strRRmodifier;
	}

	public String getStrSRObjectType() {
		return strSRObjectType;
	}

	public void setStrSRObjectType(String strSRObjectType) {
		this.strSRObjectType = strSRObjectType;
	}

	public String getStrSSubject() {
		return strSSubject;
	}

	public void setStrSSubject(String strSSubject) {
		this.strSSubject = strSSubject;
	}

	public String getStrSTitle() {
		return strSTitle;
	}

	public void setStrSTitle(String strSTitle) {
		this.strSTitle = strSTitle;
	}

	public String getStrSIFolderId() {
		return strSIFolderId;
	}

	public void setStrSIFolderId(String strSIFolderId) {
		this.strSIFolderId = strSIFolderId;
	}

	public String getStrSAContentType() {
		return strSAContentType;
	}

	public void setStrSAContentType(String strSAContentType) {
		this.strSAContentType = strSAContentType;
	}

	public boolean isBlnSAFullText() {
		return blnSAFullText;
	}

	public void setBlnSAFullText(boolean blnSAFullText) {
		this.blnSAFullText = blnSAFullText;
	}

	public String getStrSAclName() {
		return strSAclName;
	}

	public void setStrSAclName(String strSAclName) {
		this.strSAclName = strSAclName;
	}

	public String getStrSRLlockMachine() {
		return strSRLlockMachine;
	}

	public void setStrSRLlockMachine(String strSRLlockMachine) {
		this.strSRLlockMachine = strSRLlockMachine;
	}

	public String getStrSIAntecedentId() {
		return strSIAntecedentId;
	}

	public void setStrSIAntecedentId(String strSIAntecedentId) {
		this.strSIAntecedentId = strSIAntecedentId;
	}

	public String getStrSIChronicleId() {
		return strSIChronicleId;
	}

	public void setStrSIChronicleId(String strSIChronicleId) {
		this.strSIChronicleId = strSIChronicleId;
	}

	public String getBlnSRImmutableFlag() {
		return blnSRImmutableFlag;
	}

	public void setBlnSRImmutableFlag(String blnSRImmutableFlag) {
		this.blnSRImmutableFlag = blnSRImmutableFlag;
	}

	public String getDtSRLockDate() {
		return dtSRLockDate;
	}

	public void setDtSRLockDate(String dtSRLockDate) {
		this.dtSRLockDate = dtSRLockDate;
	}

	public String getStrSRLockOwner() {
		return strSRLockOwner;
	}

	public void setStrSRLockOwner(String strSRLockOwner) {
		this.strSRLockOwner = strSRLockOwner;
	}
	
	public SysObject(){
		
	}
	
	
	
	
	
}
