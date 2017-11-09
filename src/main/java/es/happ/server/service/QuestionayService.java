package es.happ.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.QuestionaryConverter;
import es.happ.server.converter.SessionQuestionaryConverter;
import es.happ.server.entity.AnswerEntity;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.SessionAnswerEntity;
import es.happ.server.entity.SessionQuestionaryEntity;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.SessionQuestionaryModel;
import es.happ.server.repositoy.AnswerRepository;
import es.happ.server.repositoy.DeviceRepository;
import es.happ.server.repositoy.QuestionaryRepository;
import es.happ.server.repositoy.SessionAnswerRepository;
import es.happ.server.repositoy.SessionQuestionaryRepository;
import es.happ.server.util.DateUtil;

/**
 * The Class QuestionayService.
 */
@Service("questionayService")
public class QuestionayService {
	
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
	
	/** The session questionary repository. */
	@Autowired
	@Qualifier("sessionQuestionaryRepository")
	private SessionQuestionaryRepository sessionQuestionaryRepository;
	
	/** The questionary converter. */
	@Autowired
	@Qualifier("sessionQuestionaryConverter")
	private SessionQuestionaryConverter sessionQuestionaryConverter;
	
	/** The session answer repository. */
	@Autowired
	@Qualifier("sessionAnswerRepository")
	private SessionAnswerRepository sessionAnswerRepository;
	
	/** The answer repository. */
	@Autowired
	@Qualifier("answerRepository")
	private AnswerRepository answerRepository;

	/** The device repository. */
	@Autowired
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;
	
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
	 * Creates the new session.
	 *
	 * @param androidId the android id
	 * @return the SessionQuestionaryModel
	 */
	public SessionQuestionaryModel createNewSession(String androidId) {
		SessionQuestionaryModel model = null;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		if (deviceEntity != null) {
			SessionQuestionaryEntity entity = sessionQuestionaryRepository.findByAndroidIdAndFinished(androidId, Boolean.FALSE);
			if (entity == null) {
				entity = new SessionQuestionaryEntity();
				entity.setDateSession(dateUtil.now());
				entity.setFinished(Boolean.FALSE);
				entity.setAndroidId(androidId);
				entity = sessionQuestionaryRepository.save(entity);
			}
			model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(entity);
		}
		return model;
	}

	/**
	 * Find session.
	 *
	 * @param sessionAnswerId the session answer id
	 * @return the session questionary model
	 */
	public SessionQuestionaryModel findSession(Long sessionAnswerId) {
		SessionQuestionaryEntity entity = sessionQuestionaryRepository.findBySessionId(sessionAnswerId);
		SessionQuestionaryModel model = null;
		if (entity != null) {
			model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(entity);
		}	
		return model;
	}


	/**
	 * Find session questionary by android id.
	 *
	 * @param sessionAnswerId the session answer id
	 * @return the session questionary model
	 */
	public SessionQuestionaryModel findFirstSessionByAndroidId(String androidIdId) {
		List<SessionQuestionaryEntity> entity = sessionQuestionaryRepository.findByAndroidIdOrderByDateSessionAsc(androidIdId);
		
		SessionQuestionaryModel model = null;
		for (SessionQuestionaryEntity sessionQuestionaryEntity : entity) {
			if (model == null 
					&& sessionQuestionaryEntity.getDateSession().getTime() <= dateUtil.now().getTime() 
					&& sessionQuestionaryEntity.getFinished() != Boolean.TRUE) {
				model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(sessionQuestionaryEntity);
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
	 * @param sessionAnswerId the session answer id
	 * @param answerId the answer id
	 * @return the session questionary model
	 */
	public SessionQuestionaryModel answerSession(String androidId, Long sessionAnswerId, Long answerId) {
		SessionQuestionaryModel model = null;

		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		SessionQuestionaryEntity sessionQuestionaryEntity = sessionQuestionaryRepository.findBySessionId(sessionAnswerId);
		AnswerEntity answerEntity = answerRepository.findByAnswerId(answerId);
		if (deviceEntity == null) {
			model = null;
		} else if (sessionQuestionaryEntity == null) {
			model = null;
		} else if (answerEntity == null) {
			model = null;
		} else {
			
			// Comprueba que no tenga otra respuesta
			boolean exist = false;
			List<SessionAnswerEntity> answers = sessionAnswerRepository.findBySessionId(sessionQuestionaryEntity.getSessionId());
			for (SessionAnswerEntity sessionAnswerEntity : answers) {
				if (sessionAnswerEntity.getQuestionId() == answerEntity.getQuestion().getQuestionId()) {
					exist = true;
				}
			}

			// Informa la respuesta
			if (!exist) {
				SessionAnswerEntity sessionAnswer = new SessionAnswerEntity();
				sessionAnswer.setSessionCuestionary(sessionQuestionaryEntity);
				sessionAnswer.setQuestionaryId(answerEntity.getQuestion().getQuestionary().getQuestionaryId());
				sessionAnswer.setQuestionId(answerEntity.getQuestion().getQuestionId());
				sessionAnswer.setAnswerId(answerId);
				
				sessionAnswerRepository.save(sessionAnswer);
			}
			
			// Verifica si es el último lo establece automáticamente
			long numberAnswers = sessionAnswerRepository.countBySessionId(sessionQuestionaryEntity.getSessionId());
			if (numberAnswers == answerEntity.getQuestion().getQuestionary().getQuestions().size()) {
				sessionQuestionaryEntity.setFinished(true);
				sessionQuestionaryRepository.save(sessionQuestionaryEntity);
			}
			
			model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(sessionQuestionaryEntity);
		}
		return model;
	}
	
	
	
}
