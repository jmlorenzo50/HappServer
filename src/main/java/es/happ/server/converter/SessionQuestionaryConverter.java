package es.happ.server.converter;

import org.springframework.stereotype.Component;
import es.happ.server.entity.SessionQuestionaryEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.SessionQuestionaryModel;
import es.happ.server.model.HappModel;

/**
 * The Class QuestionaryConverter.
 * @version 1.0
 * @author jorge
 */
@Component("sessionQuestionaryConverter")
public class SessionQuestionaryConverter implements HappConverter{

	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Questionary entity
	 */
	public HappEntity toEntity(HappModel model) {
		SessionQuestionaryModel sessionQuestionaryModel = (SessionQuestionaryModel) model;
		SessionQuestionaryEntity entity = new SessionQuestionaryEntity();
		entity.setSessionId(sessionQuestionaryModel.getSessionId());
		entity.setAndroidId(sessionQuestionaryModel.getAndroidId());
		entity.setDateSession(sessionQuestionaryModel.getDateSession());
		entity.setFinished(sessionQuestionaryModel.getFinished());
		
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Questionary model
	 */
	public HappModel toModel(HappEntity entity) {
		SessionQuestionaryEntity sessionQuestionaryEntity = (SessionQuestionaryEntity) entity;
		SessionQuestionaryModel model = new SessionQuestionaryModel();
		model.setSessionId(sessionQuestionaryEntity.getSessionId());
		model.setAndroidId(sessionQuestionaryEntity.getAndroidId());
		model.setDateSession(sessionQuestionaryEntity.getDateSession());
		model.setFinished(sessionQuestionaryEntity.getFinished());
		
		return model;
	}

}
