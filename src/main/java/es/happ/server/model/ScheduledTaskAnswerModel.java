package es.happ.server.model;


/**
 * The Class SessionAnswer.
 */
public class ScheduledTaskAnswerModel  implements HappModel{
	
	/** The scheduled task answer id. */
	private Long scheduledTaskAnswerId;
	
	/** The questionary id. */
	private Long questionaryId;

	/** The question id. */
	private Long questionId;
	
	/** The answer id. */
	private Long answerId;

	/**
	 * Instantiates a new session answer.
	 */
	public ScheduledTaskAnswerModel() {
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
