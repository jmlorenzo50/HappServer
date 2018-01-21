package es.happ.server.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.ValuationConverter;
import es.happ.server.entity.ValuationEntity;
import es.happ.server.model.ValuationModel;
import es.happ.server.repository.ValuationRepository;

/**
 * The Class ValuationService.
 */
@Service("valuationService")
public class ValuationService {
	
	@Autowired
	@Qualifier("valuationRepository")
	private ValuationRepository valuationRepository;
	
	@Autowired
	@Qualifier("valuationConverter")
	private ValuationConverter valuationConverter;
	
	/**
	 * Gets the all questionaries.
	 *
	 * @return the all questionaries
	 */
	public List<ValuationModel> list(String androidId, Timestamp valuation_date) {
		List<ValuationModel> data = new ArrayList<>();
		List<ValuationEntity> lv = valuationRepository.listValuation(androidId, valuation_date);
		for (ValuationEntity valuationEntity : lv) {
			ValuationModel model = (ValuationModel) valuationConverter.toModel(valuationEntity);
			data.add(model);
		}
		return data;
	}
	
	
}
