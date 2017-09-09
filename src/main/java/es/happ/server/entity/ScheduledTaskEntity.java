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
@Table(name="scheduled_task")
public class ScheduledTaskEntity implements HappEntity{
	
	/** The scheduled task id. */
	@Id
	@GeneratedValue
	@Column(name="scheduled_task_id", nullable=false, unique=true)
	private Long scheduledTaskId;

	/** The type task. */
	@Column(name="typeTask", nullable=false, length=10)
	private String typeTask;

	/** The scheduled date. */
	@Column(name="scheduled_date", nullable=false)
	private Timestamp scheduledDate;
	
	/** The finished date. */
	@Column(name="finished_date", nullable=true)
	private Timestamp finishedDate;
	
	/** The device. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="androidId", nullable = false)
	private DeviceEntity device;

	
	/**
	 * Instantiates a new scheduled task.
	 */
	public ScheduledTaskEntity() {
		super();
	}

	/**
	 * Gets the scheduled task id.
	 *
	 * @return the scheduled task id
	 */
	public Long getScheduledTaskId() {
		return scheduledTaskId;
	}

	/**
	 * Sets the scheduled task id.
	 *
	 * @param scheduledTaskId the new scheduled task id
	 */
	public void setScheduledTaskId(Long scheduledTaskId) {
		this.scheduledTaskId = scheduledTaskId;
	}

	/**
	 * Gets the scheduled date.
	 *
	 * @return the scheduled date
	 */
	public Timestamp getScheduledDate() {
		return scheduledDate;
	}

	/**
	 * Sets the scheduled date.
	 *
	 * @param scheduledDate the new scheduled date
	 */
	public void setScheduledDate(Timestamp scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	/**
	 * Gets the type task.
	 *
	 * @return the type task
	 */
	public String getTypeTask() {
		return typeTask;
	}

	/**
	 * Sets the type task.
	 *
	 * @param typeTask the new type task
	 */
	public void setTypeTask(String typeTask) {
		this.typeTask = typeTask;
	}

	/**
	 * Gets the finished date.
	 *
	 * @return the finished date
	 */
	public Timestamp getFinishedDate() {
		return finishedDate;
	}

	/**
	 * Sets the finished date.
	 *
	 * @param finishedDate the new finished date
	 */
	public void setFinishedDate(Timestamp finishedDate) {
		this.finishedDate = finishedDate;
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
