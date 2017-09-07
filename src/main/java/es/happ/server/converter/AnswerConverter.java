package es.happ.server.converter;

import org.springframework.stereotype.Component;

import es.happ.server.entity.AnswerEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.AnswerModel;
import es.happ.server.model.HappModel;

/**
 * The Class AnswerConverter.
 */
@Component("answerConverter")
public class AnswerConverter implements HappConverter{
	
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Answer entity
	 */
	public HappEntity toEntity(HappModel model) {
		AnswerModel answerModel = (AnswerModel) model;
		AnswerEntity entity = new AnswerEntity();
		entity.setAnswerId(answerModel.getAnswerId());
		entity.setText(answerModel.getText());
		entity.setValue(answerModel.getValue());
		entity.setQuestion(null);
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Answer model
	 */
	public HappModel toModel(HappEntity entity) {
		AnswerEntity answerEntity = (AnswerEntity) entity;
		AnswerModel model = new AnswerModel();
		model.setAnswerId(answerEntity.getAnswerId());
		model.setText(answerEntity.getText());
		model.setValue(answerEntity.getValue());
		return model;
	}

}
