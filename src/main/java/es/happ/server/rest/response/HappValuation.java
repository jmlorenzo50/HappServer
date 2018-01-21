package es.happ.server.rest.response;

import java.util.List;

import es.happ.server.model.ValuationModel;

/**
 * The Class HappEnvirotment.
 */
public class HappValuation extends HappResponse {
	
	/** The education levels. */
	private List<ValuationModel> valuationModels;

	/**
	 * Gets the valuation models.
	 *
	 * @return the valuation models
	 */
	public List<ValuationModel> getValuationModels() {
		return valuationModels;
	}

	/**
	 * Sets the valuation models.
	 *
	 * @param valuationModels the new valuation models
	 */
	public void setValuationModels(List<ValuationModel> valuationModels) {
		this.valuationModels = valuationModels;
	}



	

}
