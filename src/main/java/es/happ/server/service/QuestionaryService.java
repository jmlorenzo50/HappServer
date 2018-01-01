package es.happ.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.DeviceConverter;
import es.happ.server.converter.QuestionaryConverter;
import es.happ.server.converter.ScheduledTaskQuestionaryConverter;
import es.happ.server.entity.AnswerEntity;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.ScheduledTaskAnswerEntity;
import es.happ.server.entity.ScheduledTaskEntity;
import es.happ.server.entity.ScheduledTaskQuestionaryEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.ScheduledTaskQuestionaryModel;
import es.happ.server.repository.AnswerRepository;
import es.happ.server.repository.DeviceRepository;
import es.happ.server.repository.QuestionaryRepository;
import es.happ.server.repository.ScheduledTaskAnswerRepository;
import es.happ.server.repository.ScheduledTaskQuestionaryRepository;
import es.happ.server.repository.ScheduledTaskRepository;
import es.happ.server.util.DateUtil;

/**
 * The Class QuestionaryService.
 */
@Service("questionaryService")
public class QuestionaryService {
	
	@Autowired
	@Qualifier("dateUtil")
	private DateUtil dateUtil;
	
	/** The questionary repository. */
	@Autowired
	@Qualifier("questionaryRepository")
	private QuestionaryRepository questionaryRepository;
	
	/** The questionary converter. */
	@Autowired
	@Qualifier("questionaryConverter")
	private QuestionaryConverter questionaryConverter;
	
	/** The questionary converter. */
	@Autowired
	@Qualifier("scheduledTaskQuestionaryConverter")
	private ScheduledTaskQuestionaryConverter scheduledTaskQuestionaryConverter;
	
	/** The session answer repository. */
	@Autowired
	@Qualifier("scheduledTaskRepository")
	private ScheduledTaskRepository scheduledTaskRepository;
	
	/** The session answer repository. */
	@Autowired
	@Qualifier("scheduledTaskQuestionaryRepository")
	private ScheduledTaskQuestionaryRepository scheduledTaskQuestionaryRepository;
	
	/** The session answer repository. */
	@Autowired
	@Qualifier("scheduledTaskAnswerRepository")
	private ScheduledTaskAnswerRepository scheduledTaskAnswerRepository;
	
	/** The answer repository. */
	@Autowired
	@Qualifier("answerRepository")
	private AnswerRepository answerRepository;

	/** The device repository. */
	@Autowired
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;
	
	/** The device converter. */
	@Autowired
	@Qualifier("deviceConverter")
	private DeviceConverter deviceConverter;

	
	/**
	 * Gets the all questionaries.
	 *
	 * @return the all questionaries
	 */
	public List<QuestionaryModel> getAllQuestionaries() {
		List<QuestionaryModel> data = new ArrayList<>();
		List<QuestionaryEntity> lq = questionaryRepository.findAll();
		for (QuestionaryEntity questionaryEntity : lq) {
			QuestionaryModel model = (QuestionaryModel) questionaryConverter.toModel(questionaryEntity);
			data.add(model);
		}
		return data;
	}
	

	/**
	 * Find session questionary by android id.
	 *
	 * @param sessionAnswerId the session answer id
	 * @return the session questionary model
	 */
	public ScheduledTaskQuestionaryModel findFirstSessionByAndroidId(DeviceModel deviceModel) {
		DeviceEntity deviceEntity = (DeviceEntity) deviceConverter.toEntity(deviceModel);
		
		List<ScheduledTaskEntity> entity = scheduledTaskRepository.findByDeviceOrderByScheduledDateAsc(deviceEntity);
		
		ScheduledTaskQuestionaryModel model = null;
		for (ScheduledTaskEntity scheduledTaskEntity : entity) {
			if (model == null 
					&& scheduledTaskEntity.getScheduledDate().getTime() <= dateUtil.now().getTime() 
					&& scheduledTaskEntity.getFinishedDate() == null) {
				List<ScheduledTaskQuestionaryEntity> list = scheduledTaskQuestionaryRepository.findByScheduledTaskOrderByScheduledTaskQuestionaryIdAsc(scheduledTaskEntity);
				if (list != null && !list.isEmpty()) {
					model = (ScheduledTaskQuestionaryModel) scheduledTaskQuestionaryConverter.toModel(list.get(0));
				}
			}
		}
		return model;
	}
	

	/**
	 * Find a questinçonary
	 * @return
	 */
	public QuestionaryModel findQuestionary(Long questionaryId) {
		QuestionaryModel model = null;
		QuestionaryEntity questionaryEntity = questionaryRepository.findByQuestionaryId(questionaryId);
		if (questionaryEntity != null) {
			model = (QuestionaryModel) questionaryConverter.toModel(questionaryEntity);
		}
		return model;
	}


	
	/**
	 * Answer session.
	 *
	 * @param androidId the android id
	 * @param scheduledTaskQuestionaryId the session questionary id
	 * @param answerId the answer id
	 * @return the session questionary model
	 */
	public ScheduledTaskQuestionaryModel answerSession(String androidId, Long scheduledTaskQuestionaryId, Long answerId) {
		ScheduledTaskQuestionaryModel model = null;

		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		ScheduledTaskQuestionaryEntity scheduledTaskQuestionaryEntity = scheduledTaskQuestionaryRepository.findByScheduledTaskQuestionaryId(scheduledTaskQuestionaryId);
		AnswerEntity answerEntity = answerRepository.findByAnswerId(answerId);
		if (deviceEntity == null) {
			model = null;
		} else if (scheduledTaskQuestionaryEntity == null) {
			model = null;
		} else if (answerEntity == null) {
			model = null;
		} else {
			
			// Comprueba que no tenga otra respuesta
			boolean exist = false;
			List<ScheduledTaskAnswerEntity> answers = scheduledTaskAnswerRepository.findByScheduledTaskQuestionaryId(scheduledTaskQuestionaryEntity.getScheduledTaskQuestionaryId());
			for (ScheduledTaskAnswerEntity sessionAnswerEntity : answers) {
				if (sessionAnswerEntity.getQuestionId() == answerEntity.getQuestion().getQuestionId()) {
					exist = true;
				}
			}

			// Informa la respuesta
			if (!exist) {
				ScheduledTaskAnswerEntity sessionAnswer = new ScheduledTaskAnswerEntity();
				sessionAnswer.setAnswerId(answerId);
				sessionAnswer.setQuestionaryId(answerEntity.getQuestion().getQuestionary().getQuestionaryId());
				sessionAnswer.setQuestionId(answerEntity.getQuestion().getQuestionId());
				sessionAnswer.setScheduledTaskQuestionary(scheduledTaskQuestionaryEntity);
				scheduledTaskAnswerRepository.save(sessionAnswer);
			}
			
			// Verifica si es el último lo establece automáticamente
			long numberAnswers = scheduledTaskAnswerRepository.countByScheduledTaskQuestionaryId(scheduledTaskQuestionaryEntity.getScheduledTaskQuestionaryId());
			if (numberAnswers == answerEntity.getQuestion().getQuestionary().getQuestions().size()) {
				scheduledTaskQuestionaryEntity.setFinishedDate(dateUtil.now());
				scheduledTaskQuestionaryRepository.save(scheduledTaskQuestionaryEntity);
				scheduledTaskQuestionaryRepository.flush();
			}
			
			ScheduledTaskEntity scheduledTask = scheduledTaskQuestionaryEntity.getScheduledTask();
			if (scheduledTaskRepository.isAllQuestionaryFinish(scheduledTask)) {
				scheduledTask.setFinishedDate(dateUtil.now());
				scheduledTaskRepository.save(scheduledTask);
				scheduledTaskRepository.flush();
			}
			
			model = (ScheduledTaskQuestionaryModel) scheduledTaskQuestionaryConverter.toModel(scheduledTaskQuestionaryEntity);
		}
		return model;
	}
	
	
	
}
