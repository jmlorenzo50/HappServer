package es.happ.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class EducationLevel.
 * @author jorge
 * @version 1.0
 */
@Entity
@Table(name="education_level")
public class EducationLevelEntity implements HappEntity{
	
	/** The code. */
	@Id
	@Column(name="code", length=3, nullable=false, unique=true)
	private String code;
	
	/** The value. */
	@Column(name="value", length=1000, nullable= false)
	private String value;
	
	/** The order. */
	@Column(name="ordered", nullable= true)
	private Integer ordered;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the ordered.
	 *
	 * @return the ordered
	 */
	public Integer getOrdered() {
		return ordered;
	}

	/**
	 * Sets the ordered.
	 *
	 * @param ordered the new ordered
	 */
	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}
	
	

}
