package es.happ.server.model;

/**
 * The Class GroupModel.
 */
public class GroupModel {
	
	/** The code group. */
	private String codeGroup;
	
	/** The count group. */
	private long countGroup;

	
	/**
	 * Instantiates a new group model.
	 */
	public GroupModel() {
		super();
	}

	/**
	 * Instantiates a new group model.
	 *
	 * @param codeGroup the code group
	 * @param countGroup the count group
	 */
	public GroupModel(String codeGroup, long countGroup) {
		super();
		this.codeGroup = codeGroup;
		this.countGroup = countGroup;
	}

	/**
	 * Gets the code group.
	 *
	 * @return the code group
	 */
	public String getCodeGroup() {
		return codeGroup;
	}

	/**
	 * Sets the code group.
	 *
	 * @param codeGroup the new code group
	 */
	public void setCodeGroup(String codeGroup) {
		this.codeGroup = codeGroup;
	}

	/**
	 * Gets the count group.
	 *
	 * @return the count group
	 */
	public long getCountGroup() {
		return countGroup;
	}

	/**
	 * Sets the count group.
	 *
	 * @param countGroup the new count group
	 */
	public void setCountGroup(long countGroup) {
		this.countGroup = countGroup;
	}

	
}
