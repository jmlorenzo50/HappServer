package es.happ.server.rest.response;

import java.util.List;

import es.happ.server.model.EducationLevelModel;

/**
 * The Class HappEnvirotment.
 */
public class HappEnvirotment extends HappResponse {
	
	/** The education levels. */
	private List<EducationLevelModel> educationLevels;

	/**
	 * Gets the education levels.
	 *
	 * @return the education levels
	 */
	public List<EducationLevelModel> getEducationLevels() {
		return educationLevels;
	}

	/**
	 * Sets the education levels.
	 *
	 * @param educationLevels the new education levels
	 */
	public void setEducationLevels(List<EducationLevelModel> educationLevels) {
		this.educationLevels = educationLevels;
	}

	

}
