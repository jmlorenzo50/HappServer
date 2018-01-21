package es.happ.server.converter;

import org.springframework.stereotype.Component;

import es.happ.server.entity.ValuationEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.ValuationModel;
import es.happ.server.model.HappModel;

/**
 * The Class ValuationConverter.
 */
@Component("valuationConverter")
public class ValuationConverter implements HappConverter{
	
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Valuation entity
	 */
	public HappEntity toEntity(HappModel model) {
		ValuationModel valuationModel = (ValuationModel) model;
		ValuationEntity entity = new ValuationEntity();
		entity.setValuationId(valuationModel.getValuationId());
		entity.setValuationText(valuationModel.getValuationText());
		entity.setValuationDate(valuationModel.getValuationDate());
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Valuation model
	 */
	public HappModel toModel(HappEntity entity) {
		ValuationEntity ValuationEntity = (ValuationEntity) entity;
		ValuationModel model = new ValuationModel();
		model.setValuationId(ValuationEntity.getValuationId());
		model.setValuationText(ValuationEntity.getValuationText());
		model.setValuationDate(ValuationEntity.getValuationDate());
		return model;
	}

}
