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
@Table(name="valuation")
public class ValuationEntity implements HappEntity{
	
	/** The scheduled task id. */
	@Id
	@GeneratedValue
	@Column(name="valuation_id", nullable=false, unique=true)
	private Long valuationId;

	/** The valuation text. */
	@Column(name="valuation_text", nullable=false, length=45)
	private String valuationText;

	/** The valuation date. */
	@Column(name="valuation_date", nullable=false)
	private Timestamp valuationDate;
	
	/** The device. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="androidId", nullable = false)
	private DeviceEntity device;

	
	/**
	 * Instantiates a new scheduled task.
	 */
	public ValuationEntity() {
		super();
	}


	

	/**
	 * Gets the valuation text.
	 *
	 * @return the valuation text
	 */
	public String getValuationText() {
		return valuationText;
	}


	/**
	 * Sets the valuation text.
	 *
	 * @param valuationText the new valuation text
	 */
	public void setValuationText(String valuationText) {
		this.valuationText = valuationText;
	}


	/**
	 * Gets the valuation date.
	 *
	 * @return the valuation date
	 */
	public Timestamp getValuationDate() {
		return valuationDate;
	}


	/**
	 * Sets the valuation date.
	 *
	 * @param valuationDate the new valuation date
	 */
	public void setValuationDate(Timestamp valuationDate) {
		this.valuationDate = valuationDate;
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




	/**
	 * Gets the valuation id.
	 *
	 * @return the valuation id
	 */
	public Long getValuationId() {
		return valuationId;
	}




	/**
	 * Sets the valuation id.
	 *
	 * @param valuationId the new valuation id
	 */
	public void setValuationId(Long valuationId) {
		this.valuationId = valuationId;
	}


}
