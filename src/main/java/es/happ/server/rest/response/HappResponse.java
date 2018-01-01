package es.happ.server.rest.response;

import es.happ.server.types.TypeResponse;

/**
 * The Class HappResponse.
 */
public class HappResponse {

	/** The type response. */
	private TypeResponse typeResponse;
	
	/** The error. */
	private String error;
	
	/**
	 * Instantiates a new happ response.
	 */
	protected HappResponse() {
		super();
	}

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

	
}
