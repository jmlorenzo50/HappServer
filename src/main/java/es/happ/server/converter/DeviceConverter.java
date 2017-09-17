package es.happ.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.EducationLevelEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.EducationLevelModel;
import es.happ.server.model.HappModel;
import es.happ.server.types.Gender;
import es.happ.server.types.MaritalStatus;

/**
 * The Class DeviceConverter.
 * @author jorge
 * @version 1.0
 */
@Component("deviceConverter")
public class DeviceConverter implements HappConverter{
	
	@Autowired()
	@Qualifier("educationLevelConverter")
	private EducationLevelConverter educationLevelConverter;
	
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
		if (deviceModel.getMaritalStatus() != null) {
			entity.setMaritalStatus(deviceModel.getMaritalStatus().name());
		}
		if (deviceModel.getEducationLevelModel() != null) {
			entity.setEducationLevel((EducationLevelEntity) educationLevelConverter.toEntity(deviceModel.getEducationLevelModel()));
		}
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
		if (deviceEntity.getMaritalStatus() != null) {
			model.setMaritalStatus(MaritalStatus.valueOf(deviceEntity.getMaritalStatus()));
		}
		if (deviceEntity.getEducationLevel() != null) {
			model.setEducationLevelModel((EducationLevelModel) educationLevelConverter.toModel(deviceEntity.getEducationLevel()));
		}
		return model;
	}

}
