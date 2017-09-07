package es.happ.server.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.entity.QuestionEntity;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.HappModel;
import es.happ.server.model.QuestionModel;

/**
 * The Class QuestionaryConverter.
 */
@Component("questionaryConverter")
public class QuestionaryConverter implements HappConverter{
	
	@Autowired
	@Qualifier("questionConverter")
	private QuestionConverter questionConverter;

	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Questionary entity
	 */
	public HappEntity toEntity(HappModel model) {
		QuestionaryModel questionaryModel = (QuestionaryModel) model;
		QuestionaryEntity entity = new QuestionaryEntity();
		entity.setQuestionaryId(questionaryModel.getQuestionaryId());
		entity.setDescription(questionaryModel.getDescription());
		entity.setStatement(questionaryModel.getStatement());
		
		Set<QuestionEntity> questions = new HashSet<QuestionEntity>();
		Set<QuestionModel> lq = questionaryModel.getQuestions();
		for (QuestionModel questionModel : lq) {
			QuestionEntity qe = (QuestionEntity) questionConverter.toEntity(questionModel);
			qe.setQuestionary(entity);
			questions.add(qe);
		}
		entity.setQuestions(questions);
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Questionary model
	 */
	public HappModel toModel(HappEntity entity) {
		QuestionaryEntity questionaryEntity = (QuestionaryEntity) entity;
		QuestionaryModel model = new QuestionaryModel();
		model.setQuestionaryId(questionaryEntity.getQuestionaryId());
		model.setDescription(questionaryEntity.getDescription());
		model.setStatement(questionaryEntity.getStatement());
		
		Set<QuestionModel> questions = new HashSet<QuestionModel>();
		Set<QuestionEntity> lq = questionaryEntity.getQuestions();
		for (QuestionEntity answerEntity : lq) {
			QuestionModel qm = (QuestionModel) questionConverter.toModel(answerEntity);
			questions.add(qm);
		}
		model.setQuestions(questions);
		
		return model;
	}

}
