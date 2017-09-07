package es.happ.server.converter;

import org.springframework.stereotype.Component;
import es.happ.server.entity.SessionQuestionaryEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.SessionQuestionaryModel;
import es.happ.server.model.HappModel;

/**
 * The Class QuestionaryConverter.
 */
@Component("sessionQuestionaryConverter")
public class SessionQuestionaryConverter implements HappConverter{
	/*
	@Autowired
	@Qualifier("questionConverter")
	private QuestionConverter questionConverter;
	*/

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
		
		/*
		Set<QuestionEntity> questions = new HashSet<QuestionEntity>();
		Set<QuestionModel> lq = sessionQuestionaryModel.getQuestions();
		for (QuestionModel questionModel : lq) {
			QuestionEntity qe = (QuestionEntity) questionConverter.toEntity(questionModel);
			qe.setQuestionary(entity);
			questions.add(qe);
		}
		entity.setQuestions(questions);*/
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
		
		/*
		Set<QuestionModel> questions = new HashSet<QuestionModel>();
		Set<QuestionEntity> lq = sessionQuestionaryEntity.getQuestions();
		for (QuestionEntity answerEntity : lq) {
			QuestionModel qm = (QuestionModel) questionConverter.toModel(answerEntity);
			questions.add(qm);
		}
		model.setQuestions(questions);
		*/
		return model;
	}

}
