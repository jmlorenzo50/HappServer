package es.happ.server.converter;

import org.springframework.stereotype.Component;

import es.happ.server.entity.EducationLevelEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.EducationLevelModel;
import es.happ.server.model.HappModel;

/**
 * The Class EducationLevelConverter.
 * @author jorge
 * @version 1.0
 */
@Component("educationLevelConverter")
public class EducationLevelConverter implements HappConverter{

	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the EducationLevel entity
	 */
	public HappEntity toEntity(HappModel model) {
		EducationLevelModel educationLevelModel = (EducationLevelModel) model;
		EducationLevelEntity entity = new EducationLevelEntity();
		entity.setCode(educationLevelModel.getCode());
		entity.setValue(educationLevelModel.getValue());
		entity.setOrdered(educationLevelModel.getOrdered());
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the EducationLevel model
	 */
	public HappModel toModel(HappEntity entity) {
		EducationLevelEntity educationLevelEntity = (EducationLevelEntity) entity;
		EducationLevelModel model = new EducationLevelModel();
		model.setCode(educationLevelEntity.getCode());
		model.setValue(educationLevelEntity.getValue());
		model.setOrdered(educationLevelEntity.getOrdered());
		return model;
	}
}
