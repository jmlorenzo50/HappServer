package es.happ.server.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class ScheduledTask.
 */
@Entity
@Table(name="wellness")
public class WellnessEntity implements HappEntity{
	
	/** The scheduled task id. */
	@Id
	@GeneratedValue
	@Column(name="wellness_id", nullable=false, unique=true)
	private Long wellnessId;

	/** The wellness good. */
	@Column(name="wellness_good", nullable=false)
	private Integer wellnessGood;

	/** The wellness bad. */
	@Column(name="wellness_bad", nullable=false)
	private Integer wellnessBad;

	/** The wellness date. */
	@Column(name="wellness_date", nullable=false)
	private Timestamp wellnessDate;
	
	/** The device. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="androidId", nullable = false)
	private DeviceEntity device;

	
	/**
	 * Instantiates a new scheduled task.
	 */
	public WellnessEntity() {
		super();
	}

	
	/**
	 * Gets the wellness id.
	 *
	 * @return the wellness id
	 */
	public Long getWellnessId() {
		return wellnessId;
	}


	/**
	 * Sets the wellness id.
	 *
	 * @param wellnessId the new wellness id
	 */
	public void setWellnessId(Long wellnessId) {
		this.wellnessId = wellnessId;
	}


	/**
	 * Gets the wellness good.
	 *
	 * @return the wellness good
	 */
	public Integer getWellnessGood() {
		return wellnessGood;
	}


	/**
	 * Sets the wellness good.
	 *
	 * @param wellnessGood the new wellness good
	 */
	public void setWellnessGood(Integer wellnessGood) {
		this.wellnessGood = wellnessGood;
	}


	/**
	 * Gets the wellness bad.
	 *
	 * @return the wellness bad
	 */
	public Integer getWellnessBad() {
		return wellnessBad;
	}


	/**
	 * Sets the wellness bad.
	 *
	 * @param wellnessBad the new wellness bad
	 */
	public void setWellnessBad(Integer wellnessBad) {
		this.wellnessBad = wellnessBad;
	}


	/**
	 * Gets the wellness date.
	 *
	 * @return the wellness date
	 */
	public Timestamp getWellnessDate() {
		return wellnessDate;
	}


	/**
	 * Sets the wellness date.
	 *
	 * @param wellnessDate the new wellness date
	 */
	public void setWellnessDate(Timestamp wellnessDate) {
		this.wellnessDate = wellnessDate;
	}


	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public DeviceEntity getDevice() {
		return device;
	}


	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(DeviceEntity device) {
		this.device = device;
	}


}
