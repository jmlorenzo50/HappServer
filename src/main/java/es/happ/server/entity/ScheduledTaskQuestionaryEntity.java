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
 * The Class ScheduledTaskQuestionaryEntity.
 */
@Entity
@Table(name="scheduledTaskQuestionaryEntity")
public class ScheduledTaskQuestionaryEntity implements HappEntity{
	
	/** The scheduled task id. */
	@Id
	@GeneratedValue
	@Column(name="scheduled_task_questionary_id", nullable=false, unique=true)
	private Long scheduledTaskQuestionaryId;
	
	/** The questionary. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="questionaryId", nullable = false)
	private QuestionaryEntity questionary;

	/** The device. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="scheduledTaskId", nullable = false)
	private ScheduledTaskEntity scheduledTask;
	
	/** The finished date. */
	@Column(name="finished_date", nullable=true)
	private Timestamp finishedDate;

	/**
	 * Instantiates a new scheduled task questionary entity.
	 */
	public ScheduledTaskQuestionaryEntity() {
		super();
	}

	/**
	 * Gets the scheduled task questionary id.
	 *
	 * @return the scheduled task questionary id
	 */
	public Long getScheduledTaskQuestionaryId() {
		return scheduledTaskQuestionaryId;
	}

	/**
	 * Sets the scheduled task questionary id.
	 *
	 * @param scheduledTaskQuestionaryId the new scheduled task questionary id
	 */
	public void setScheduledTaskQuestionaryId(Long scheduledTaskQuestionaryId) {
		this.scheduledTaskQuestionaryId = scheduledTaskQuestionaryId;
	}

	/**
	 * Gets the questionary.
	 *
	 * @return the questionary
	 */
	public QuestionaryEntity getQuestionary() {
		return questionary;
	}

	/**
	 * Sets the questionary.
	 *
	 * @param questionary the new questionary
	 */
	public void setQuestionary(QuestionaryEntity questionary) {
		this.questionary = questionary;
	}

	/**
	 * Gets the scheduled task.
	 *
	 * @return the scheduled task
	 */
	public ScheduledTaskEntity getScheduledTask() {
		return scheduledTask;
	}

	/**
	 * Sets the scheduled task.
	 *
	 * @param scheduledTask the new scheduled task
	 */
	public void setScheduledTask(ScheduledTaskEntity scheduledTask) {
		this.scheduledTask = scheduledTask;
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

}
