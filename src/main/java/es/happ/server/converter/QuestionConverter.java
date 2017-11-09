package es.happ.server.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.happ.server.entity.QuestionEntity;
import es.happ.server.entity.AnswerEntity;
import es.happ.server.entity.HappEntity;
import es.happ.server.model.QuestionModel;
import es.happ.server.model.AnswerModel;
import es.happ.server.model.HappModel;

/**
 * The Class QuestionConverter.
 */
@Component("questionConverter")
public class QuestionConverter implements HappConverter{
	
	
	@Autowired
	@Qualifier("answerConverter")
	private AnswerConverter answerConverter;
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Question entity
	 */
	public HappEntity toEntity(HappModel model) {
		QuestionModel questionModel = (QuestionModel) model;
		QuestionEntity entity = new QuestionEntity();
		entity.setQuestionId(questionModel.getQuestionId());
		entity.setDescription(questionModel.getDescription());
		entity.setStatement(questionModel.getStatement());
		entity.setQuestionary(null);
		
		List<AnswerEntity> answers = new ArrayList<>();
		List<AnswerModel> la = questionModel.getAnswers();
		for (AnswerModel answerModel : la) {
			AnswerEntity ae = (AnswerEntity) answerConverter.toEntity(answerModel);
			ae.setQuestion(entity);
			answers.add(ae);
		}
		entity.setAnswers(answers);
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Question model
	 */
	public HappModel toModel(HappEntity entity) {
		QuestionEntity questionEntity = (QuestionEntity) entity;
		QuestionModel model = new QuestionModel();
		model.setQuestionId(questionEntity.getQuestionId());
		model.setDescription(questionEntity.getDescription());
		model.setStatement(questionEntity.getStatement());
		
		List<AnswerModel> answers = new ArrayList<>();
		List<AnswerEntity> le = questionEntity.getAnswers();
		for (AnswerEntity answerEntity : le) {
			AnswerModel am = (AnswerModel) answerConverter.toModel(answerEntity);
			answers.add(am);
		}
		model.setAnswers(answers);
		return model;
	}

}
