package es.happ.server.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.happ.server.entity.HappEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.ScheduledTaskAnswerEntity;
import es.happ.server.entity.ScheduledTaskQuestionaryEntity;
import es.happ.server.model.HappModel;
import es.happ.server.model.ScheduledTaskAnswerModel;
import es.happ.server.model.ScheduledTaskQuestionaryModel;

/**
 * The Class QuestionaryConverter.
 * @version 1.0
 * @author jorge
 */
@Component("scheduledTaskQuestionaryConverter")
public class ScheduledTaskQuestionaryConverter implements HappConverter{
	
	@Autowired
	@Qualifier("scheduledTaskAnswerConverter")
	private ScheduledTaskAnswerConverter scheduledTaskAnswerConverter;

	@Autowired
	@Qualifier("questionaryConverter")
	private QuestionaryConverter questionaryConverter;
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the Questionary entity
	 */
	public HappEntity toEntity(HappModel model) {
		ScheduledTaskQuestionaryModel modelCast = (ScheduledTaskQuestionaryModel) model;
		QuestionaryEntity questionary = (QuestionaryEntity) questionaryConverter.toEntity(modelCast.getQuestionary());
		ScheduledTaskQuestionaryEntity entity = new ScheduledTaskQuestionaryEntity();
		entity.setScheduledTaskQuestionaryId(modelCast.getScheduledTaskQuestionaryId());
		entity.setQuestionary(questionary);
		entity.setScheduledTask(null); //TODO indicar 
		entity.setFinishedDate(modelCast.getFinishedDate());
		return entity;
	}

	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the Questionary model
	 */
	public HappModel toModel(HappEntity entity) {
		ScheduledTaskQuestionaryEntity parEntity = (ScheduledTaskQuestionaryEntity) entity;
		ScheduledTaskQuestionaryModel model = new ScheduledTaskQuestionaryModel();
		model.setScheduledTaskQuestionaryId(parEntity.getScheduledTaskQuestionaryId());
		model.setScheduledTaskId(parEntity.getScheduledTask().getScheduledTaskId());
		model.setAndroidId(parEntity.getScheduledTask().getDevice().getAndroidId());
		model.setFinishedDate(parEntity.getFinishedDate());
		model.setQuestionaryId(parEntity.getQuestionary().getQuestionaryId());
		
		List<ScheduledTaskAnswerModel> answers = new ArrayList<>();
		List<ScheduledTaskAnswerEntity> le = parEntity.getScheduledTaskAnswer();
		for (ScheduledTaskAnswerEntity scheduledTaskAnswerEntity : le) {
			ScheduledTaskAnswerModel am = (ScheduledTaskAnswerModel) scheduledTaskAnswerConverter.toModel(scheduledTaskAnswerEntity);
			answers.add(am);
		}
		model.setScheduledTaskAnswerModel(answers); 
		 
		return model;
	}

}
