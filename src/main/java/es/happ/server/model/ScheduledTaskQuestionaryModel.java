package es.happ.server.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class SessionCuestionary.
 * @author Jorge
 * @version 1.0
 */
public class ScheduledTaskQuestionaryModel implements HappModel{
	
	/** The session id. */
	private Long scheduledTaskQuestionaryId;
	
	/** The android id. */
	private String androidId;
	
	/** The questionary id. */
	private Long questionaryId;

	/** The date session. */
	private Long scheduledTaskId;  
	
	/** The finished. */
	private Timestamp finishedDate;
	
	/** The session answers. */
	private List<ScheduledTaskAnswerModel> scheduledTaskAnswerModel = new ArrayList();
	
	/** The questionary model. */
	private QuestionaryModel questionary;

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
	 * Gets the scheduled task answer model.
	 *
	 * @return the scheduled task answer model
	 */
	public List<ScheduledTaskAnswerModel> getScheduledTaskAnswerModel() {
		return scheduledTaskAnswerModel;
	}

	/**
	 * Sets the scheduled task answer model.
	 *
	 * @param scheduledTaskAnswerModel the new scheduled task answer model
	 */
	public void setScheduledTaskAnswerModel(List<ScheduledTaskAnswerModel> scheduledTaskAnswerModel) {
		this.scheduledTaskAnswerModel = scheduledTaskAnswerModel;
	}

	/**
	 * Gets the questionary model.
	 *
	 * @return the questionary model
	 */
	public QuestionaryModel getQuestionary() {
		return questionary;
	}

	/**
	 * Sets the questionary model.
	 *
	 * @param questionaryModel the new questionary model
	 */
	public void setQuestionary(QuestionaryModel questionary) {
		this.questionary = questionary;
	}



}
