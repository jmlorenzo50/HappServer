package es.happ.server.converter;

import org.springframework.stereotype.Component;

import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.HappModel;
import es.happ.server.types.Gender;

/**
 * The Class DeviceConverter.
 */
@Component("deviceConverter")
public class DeviceConverter implements HappConverter{
	
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the device entity
	 */
	public HappEntity toEntity(HappModel model) {
		DeviceModel deviceModel = (DeviceModel) model;
		DeviceEntity entity = new DeviceEntity();
		entity.setAndroidId(deviceModel.getAndroidId());
		entity.setGender(deviceModel.getGender().name());
		entity.setAge(deviceModel.getAge());
		entity.setDateInsert(deviceModel.getDateInsert());
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the device model
	 */
	public HappModel toModel(HappEntity entity) {
		DeviceEntity deviceEntity = (DeviceEntity) entity;
		DeviceModel model = new DeviceModel();
		model.setAndroidId(deviceEntity.getAndroidId());
		model.setGender(Gender.valueOf(deviceEntity.getGender()));
		model.setAge(deviceEntity.getAge());
		model.setDateInsert(deviceEntity.getDateInsert());
		return model;
	}

}
