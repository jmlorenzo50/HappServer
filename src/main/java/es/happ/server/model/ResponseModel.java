package es.happ.server.model;

import java.util.List;

import es.happ.server.types.TypeResponse;

/**
 * The Class ResponseModel.
 */
public class ResponseModel implements HappModel{
	
	/** The type response. */
	private TypeResponse typeResponse;
	
	/** The error. */
	private String error;
	
	/** The device model. */
	private DeviceModel deviceModel;
	
	/** The questionary. */
	private List<QuestionaryModel> questionary; 
	
	/** The session questionary. */
	private SessionQuestionaryModel sessionQuestionary;
	

	/**
	 * Gets the type response.
	 *
	 * @return the type response
	 */
	public TypeResponse getTypeResponse() {
		return typeResponse;
	}

	/**
	 * Sets the type response.
	 *
	 * @param typeResponse the new type response
	 */
	public void setTypeResponse(TypeResponse typeResponse) {
		this.typeResponse = typeResponse;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Gets the device model.
	 *
	 * @return the device model
	 */
	public DeviceModel getDeviceModel() {
		return deviceModel;
	}

	/**
	 * Sets the device model.
	 *
	 * @param deviceModel the new device model
	 */
	public void setDeviceModel(DeviceModel deviceModel) {
		this.deviceModel = deviceModel;
	}

	/**
	 * Gets the questionary.
	 *
	 * @return the questionary
	 */
	public List<QuestionaryModel> getQuestionary() {
		return questionary;
	}

	/**
	 * Sets the questionary.
	 *
	 * @param questionary the new questionary
	 */
	public void setQuestionary(List<QuestionaryModel> questionary) {
		this.questionary = questionary;
	}

	/**
	 * Gets the session questionary.
	 *
	 * @return the session questionary
	 */
	public SessionQuestionaryModel getSessionQuestionary() {
		return sessionQuestionary;
	}

	/**
	 * Sets the session questionary.
	 *
	 * @param sessionQuestionary the new session questionary
	 */
	public void setSessionQuestionary(SessionQuestionaryModel sessionQuestionary) {
		this.sessionQuestionary = sessionQuestionary;
	}

}
