package es.happ.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class SessionAnswer.
 * @author jorge
 * @version 1.0
 */
@Entity
@Table(name="scheduled_task_answer")
public class ScheduledTaskAnswerEntity  implements HappEntity{
	
	/** The session answer id. */
	@Id
	@GeneratedValue
	@Column(name="scheduled_task_answer_id", nullable=false, unique=true)
	private Long scheduledTaskAnswerId;
	
	/** The scheduled task id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="scheduledTaskQuestionaryId", nullable = false)
	private ScheduledTaskQuestionaryEntity scheduledTaskQuestionary;
	
	/** The questionary id. */
	@Column(name="questionary_id", nullable=false)
	private Long questionaryId;

	/** The question id. */
	@Column(name="question_id", nullable=false)
	private Long questionId;
	
	/** The answer id. */
	@Column(name="answer_id", nullable=false)
	private Long answerId;

	/**
	 * Instantiates a new session answer.
	 */
	public ScheduledTaskAnswerEntity() {
		super();
	}


	/**
	 * Gets the questionary id.
	 *
	 * @return the questionary id
	 */
	public Long getQuestionaryId() {
		return questionaryId;
	}

	/**
	 * Sets the questionary id.
	 *
	 * @param questionaryId the new questionary id
	 */
	public void setQuestionaryId(Long questionaryId) {
		this.questionaryId = questionaryId;
	}

	/**
	 * Gets the question id.
	 *
	 * @return the question id
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * Sets the question id.
	 *
	 * @param questionId the new question id
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * Gets the answer id.
	 *
	 * @return the answer id
	 */
	public Long getAnswerId() {
		return answerId;
	}

	/**
	 * Sets the answer id.
	 *
	 * @param answerId the new answer id
	 */
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	/**
	 * Gets the scheduled task questionary entity.
	 *
	 * @return the scheduled task questionary entity
	 */
	public ScheduledTaskQuestionaryEntity getScheduledTaskQuestionary() {
		return scheduledTaskQuestionary;
	}

	/**
	 * Sets the scheduled task questionary entity.
	 *
	 * @param scheduledTaskQuestionaryEntity the new scheduled task questionary entity
	 */
	public void setScheduledTaskQuestionary(ScheduledTaskQuestionaryEntity scheduledTaskQuestionary) {
		this.scheduledTaskQuestionary = scheduledTaskQuestionary;
	}


	/**
	 * Gets the scheduled task answer id.
	 *
	 * @return the scheduled task answer id
	 */
	public Long getScheduledTaskAnswerId() {
		return scheduledTaskAnswerId;
	}


	/**
	 * Sets the scheduled task answer id.
	 *
	 * @param scheduledTaskAnswerId the new scheduled task answer id
	 */
	public void setScheduledTaskAnswerId(Long scheduledTaskAnswerId) {
		this.scheduledTaskAnswerId = scheduledTaskAnswerId;
	}
	
	

}
