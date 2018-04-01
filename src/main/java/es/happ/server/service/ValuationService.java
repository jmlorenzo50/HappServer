package es.happ.server.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.ValuationConverter;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.ValuationEntity;
import es.happ.server.entity.WellnessEntity;
import es.happ.server.model.ValuationModel;
import es.happ.server.repository.DeviceRepository;
import es.happ.server.repository.ValuationRepository;
import es.happ.server.repository.WellnessRepository;
import es.happ.server.util.DateUtil;

/**
 * The Class ValuationService.
 */
@Service("valuationService")
public class ValuationService {
	
	/** The valuation repository. */
	@Autowired
	@Qualifier("valuationRepository")
	private ValuationRepository valuationRepository;
	

	/** The wellness repository. */
	@Autowired
	@Qualifier("wellnessRepository")
	private WellnessRepository wellnessRepository;
	
	
	/** The valuation converter. */
	@Autowired
	@Qualifier("valuationConverter")
	private ValuationConverter valuationConverter;
	
	/** The date util. */
	@Autowired
	@Qualifier("dateUtil")
	private DateUtil dateUtil;
	
	/** The device repository. */
	@Autowired
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;

	
	/**
	 * Gets the all questionaries.
	 *
	 * @param androidId the android id
	 * @param valuation_date the valuation date
	 * @return the all questionaries
	 */
	public List<ValuationModel> list(String androidId, Timestamp valuation_date) {
		Timestamp valuation_date_begin = dateUtil.dayAddDay(valuation_date, -1);
		
		List<ValuationModel> data = new ArrayList<>();
		List<ValuationEntity> lv = valuationRepository.listValuation(androidId, valuation_date_begin, valuation_date);
		for (ValuationEntity valuationEntity : lv) {
			ValuationModel model = (ValuationModel) valuationConverter.toModel(valuationEntity);
			data.add(model);
		}
		return data;
	}


	/**
	 * Wellness.
	 *
	 * @param androidId the android id
	 * @param timestamp the timestamp
	 * @param valueGood the value good
	 * @param valueBad the value bad
	 * @return true, if successful
	 */
	public boolean wellness(String androidId, Timestamp timestamp, int valueGood, int valueBad) {
		boolean correct = false;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);

		if (deviceEntity != null) {
			WellnessEntity we = new WellnessEntity();
			we.setDevice(deviceEntity);
			we.setWellnessBad(valueBad);
			we.setWellnessGood(valueGood);
			we.setWellnessDate(timestamp);
			wellnessRepository.save(we);
			
			correct = true;
		} 
		
		return correct;
	}


	/**
	 * Adds the.
	 *
	 * @param androidId the android id
	 * @param timestamp the timestamp
	 * @param text the text
	 * @return true, if successful
	 */
	public boolean add(String androidId, Timestamp timestamp, String text) {
		boolean correct = false;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);

		if (deviceEntity != null) {
			ValuationEntity ve = new ValuationEntity();
			ve.setDevice(deviceEntity);
			ve.setValuationDate(timestamp);
			ve.setValuationText(text);
			
			valuationRepository.save(ve);
			correct = true;
		} 
		
		return correct;
	}
	
	
}
