package es.happ.server.types;

/**
 * The Class MessagesConstans.
 * @version 1.0
 * @author jorge
 */
public class MessagesConstans {
	
	/**
	 * Contructor PRIVATE
	 */
	private MessagesConstans() {
		super();
	}
	
	/** The Constant ERROR_DEVICE_NOT_FOUND. */
	public static final String ERROR_DEVICE_NOT_FOUND = "Device not found";
	
	/** The Constant ERROR_DEVICE_NOT_ADD_BECAUSE_EXIST. */
	public static final String ERROR_DEVICE_NOT_ADD_BECAUSE_EXIST = "The device can not be added because it is already registered";
	
	/** The Constant ERROR_DEVICE_NOT_ADD. */
	public static final String ERROR_DEVICE_NOT_ADD = "The device can not be added and we don't know the cause";

	/** The Constant ERROR_SESSION_NOT_FOUND. */
	public static final String ERROR_SESSION_NOT_FOUND = "Session not found";

	/** The Constant ERROR_QUESTION_NOT_ANSWER. */
	public static final String ERROR_QUESTION_NOT_ANSWER = "The question can not be answered";

	/** The Constant ERROR_DEVICE_NOT_UPDATE. */
	public static final String ERROR_DEVICE_NOT_UPDATE = "The device can not be updated and we don't know the cause";

}
