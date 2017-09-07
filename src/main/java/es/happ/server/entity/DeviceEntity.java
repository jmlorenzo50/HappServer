package es.happ.server.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class DeviceEntity.
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
	
	

}
