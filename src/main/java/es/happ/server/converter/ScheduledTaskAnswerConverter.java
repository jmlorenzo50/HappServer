package es.happ.server.converter;

import org.springframework.stereotype.Component;

import es.happ.server.entity.HappEntity;
import es.happ.server.entity.ScheduledTaskAnswerEntity;
import es.happ.server.model.HappModel;
import es.happ.server.model.ScheduledTaskAnswerModel;

/**
 * The Class AnswerConverter.
 */
@Component("scheduledTaskAnswerConverter")
public class ScheduledTaskAnswerConverter implements HappConverter{
	
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Answer entity
	 */
	public HappEntity toEntity(HappModel model) {
		ScheduledTaskAnswerModel answerModel = (ScheduledTaskAnswerModel) model;
		ScheduledTaskAnswerEntity entity = new ScheduledTaskAnswerEntity();
		entity.setScheduledTaskAnswerId(answerModel.getScheduledTaskAnswerId());
		entity.setAnswerId(answerModel.getAnswerId());
		entity.setQuestionaryId(answerModel.getQuestionaryId());
		entity.setQuestionId(answerModel.getQuestionId());
		entity.setScheduledTaskQuestionary(null);//TODO no se si hay que indicarlo
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Answer model
	 */
	public HappModel toModel(HappEntity entity) {
		ScheduledTaskAnswerEntity parEntity = (ScheduledTaskAnswerEntity) entity;
		ScheduledTaskAnswerModel model = new ScheduledTaskAnswerModel();
		model.setAnswerId(parEntity.getAnswerId());
		model.setQuestionaryId(parEntity.getQuestionaryId());
		model.setQuestionId(parEntity.getQuestionId());
		model.setScheduledTaskAnswerId(parEntity.getScheduledTaskAnswerId());
		return model;
	}

}
