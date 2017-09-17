package es.happ.server.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class DeviceEntity.
 * @author jorge
 * @version 1.0
 */
@Entity
@Table(name="device")
public class DeviceEntity implements HappEntity {
	
	/** The android id. */
	@Id
	@Column(name="android_id",length=32, nullable=false, unique=true)
	private String androidId;
	
	/** The gender. */
	@Column(name="gender", length=5, nullable=true)
	private String gender;
	
	/** The age. */
	@Column(name="age", nullable=true)
	private Integer age;
	
	/** The date insert. */
	@Column(name="date_insert", nullable=true)
	private Timestamp dateInsert;
	
	/** The marital status. */
	@Column(name="marital_status", length=10, nullable=true)
	private String maritalStatus;
	
	/** The education level. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition="code_education_level", referencedColumnName ="code", nullable = true)
	private EducationLevelEntity educationLevel;
	
	/**
	 * Instantiates a new device entity.
	 */
	public DeviceEntity() {
		super();
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
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
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
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the new marital status
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Gets the education level.
	 *
	 * @return the education level
	 */
	public EducationLevelEntity getEducationLevel() {
		return educationLevel;
	}

	/**
	 * Sets the education level.
	 *
	 * @param educationLevel the new education level
	 */
	public void setEducationLevel(EducationLevelEntity educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	

}
