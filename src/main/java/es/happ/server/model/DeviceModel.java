package es.happ.server.model;

import java.sql.Timestamp;

import es.happ.server.types.Gender;
import es.happ.server.types.MaritalStatus;

/**
 * The Class DeviceModel.
 * @author jorge
 * @version 1.1
 */
public class DeviceModel implements HappModel{
	
	/** The android id. */
	private String androidId;
	
	/** The gender. */
	private Gender gender;
	
	/** The age. */
	private Integer age;
	
	/** The date insert. */
	private Timestamp dateInsert;
	
	/** The marital status. */
	private MaritalStatus maritalStatus;
	
	/** The education level model. */
	private EducationLevelModel educationLevelModel;
	
	/** The group. */
	private String group;
	
	/**
	 * Instantiates a new device model.
	 */
	public DeviceModel() {
		super();
	}

	/**
	 * Instantiates a new device model.
	 *
	 * @param androidId the android id
	 * @param gender the gender
	 */
	public DeviceModel(String androidId, Gender gender) {
		super();
		this.androidId = androidId;
		this.gender = gender;
	}

	/**
	 * Gets the android id.
	 *
	 * @return the android id
	 */
	public String getAndroidId() {
		return androidId;
	}

	/**
	 * Sets the android id.
	 *
	 * @param androidId the new android id
	 */
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the date insert.
	 *
	 * @return the date insert
	 */
	public Timestamp getDateInsert() {
		return dateInsert;
	}

	/**
	 * Sets the date insert.
	 *
	 * @param dateInsert the new date insert
	 */
	public void setDateInsert(Timestamp dateInsert) {
		this.dateInsert = dateInsert;
	}

	/**
	 * Gets the marital status.
	 *
	 * @return the marital status
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the new marital status
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Gets the education level model.
	 *
	 * @return the education level model
	 */
	public EducationLevelModel getEducationLevelModel() {
		return educationLevelModel;
	}

	/**
	 * Sets the education level model.
	 *
	 * @param educationLevelModel the new education level model
	 */
	public void setEducationLevelModel(EducationLevelModel educationLevelModel) {
		this.educationLevelModel = educationLevelModel;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	

}
