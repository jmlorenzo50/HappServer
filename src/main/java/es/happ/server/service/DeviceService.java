package es.happ.server.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.DeviceConverter;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.repositoy.DeviceRepository;
import es.happ.server.types.Gender;

/**
 * The Class DeviceService.
 */
@Service("deviceService")
public class DeviceService {
	
	/** The device repository. */
	@Autowired
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;
	
	/** The device converter. */
	@Autowired
	@Qualifier("deviceConverter")
	private DeviceConverter deviceConverter;
	
	/**
	 * Search device.
	 *
	 * @param androidId the android id
	 * @return the device model
	 */
	public DeviceModel searchDevice(String androidId) {
		DeviceModel deviceModel = null;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		if (deviceEntity != null) {
			deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
		}
		return deviceModel;
	}

	/**
	 * Adds the device.
	 *
	 * @param id the id
	 * @return the device model
	 */
	public DeviceModel addDevice(String id) {
		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setAndroidId(id);
		deviceEntity.setGender(Gender.NONE.name());
		deviceEntity.setAge(-1);
		deviceEntity.setDateInsert(new Timestamp(new Date().getTime()));
		deviceRepository.save(deviceEntity);
		
		DeviceModel deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
		return deviceModel;
	}

}
