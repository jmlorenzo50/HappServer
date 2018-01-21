package es.happ.server.model;

import java.sql.Timestamp;

/**
 * The Class ScheduledTask.
 */
public class ValuationModel implements HappModel{
	
	/** The scheduled task id. */
	private Long valuationId;

	/** The valuation text. */
	private String valuationText;

	/** The valuation date. */
	private Timestamp valuationDate;
	
	/**
	 * Instantiates a new scheduled task.
	 */
	public ValuationModel() {
		super();
	}

	/**
	 * Gets the valuation text.
	 *
	 * @return the valuation text
	 */
	public String getValuationText() {
		return valuationText;
	}


	/**
	 * Sets the valuation text.
	 *
	 * @param valuationText the new valuation text
	 */
	public void setValuationText(String valuationText) {
		this.valuationText = valuationText;
	}


	/**
	 * Gets the valuation date.
	 *
	 * @return the valuation date
	 */
	public Timestamp getValuationDate() {
		return valuationDate;
	}


	/**
	 * Sets the valuation date.
	 *
	 * @param valuationDate the new valuation date
	 */
	public void setValuationDate(Timestamp valuationDate) {
		this.valuationDate = valuationDate;
	}


	/**
	 * Gets the valuation id.
	 *
	 * @return the valuation id
	 */
	public Long getValuationId() {
		return valuationId;
	}

	/**
	 * Sets the valuation id.
	 *
	 * @param valuationId the new valuation id
	 */
	public void setValuationId(Long valuationId) {
		this.valuationId = valuationId;
	}


}
