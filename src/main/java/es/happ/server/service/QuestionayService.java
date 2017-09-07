package es.happ.server.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.QuestionaryConverter;
import es.happ.server.converter.SessionQuestionaryConverter;
import es.happ.server.entity.AnswerEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.SessionAnswerEntity;
import es.happ.server.entity.SessionQuestionaryEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.SessionQuestionaryModel;
import es.happ.server.repositoy.AnswerRepository;
import es.happ.server.repositoy.QuestionaryRepository;
import es.happ.server.repositoy.SessionAnswerRepository;
import es.happ.server.repositoy.SessionQuestionaryRepository;

/**
 * The Class QuestionayService.
 */
@Service("questionayService")
public class QuestionayService {
	
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
	
	@Autowired
	@Qualifier("sessionAnswerRepository")
	private SessionAnswerRepository sessionAnswerRepository;
	
	@Autowired
	@Qualifier("answerRepository")
	private AnswerRepository answerRepository;

	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	/**
	 * Gets the all questionaries.
	 *
	 * @return the all questionaries
	 */
	public List<QuestionaryModel> getAllQuestionaries() {
		List<QuestionaryModel> data = new ArrayList<QuestionaryModel>();
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
		DeviceModel device = deviceService.searchDevice(androidId);
		if (device != null) {
			SessionQuestionaryEntity entity = sessionQuestionaryRepository.findByAndroidIdAndFinished(androidId, Boolean.FALSE);
			if (entity == null) {
				entity = new SessionQuestionaryEntity();
				entity.setDateSession(new Timestamp(new Date().getTime()));
				entity.setFinished(Boolean.FALSE);
				entity.setAndroidId(androidId);
				entity = sessionQuestionaryRepository.save(entity);
			}
			model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(entity);;
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
	 * Answer session.
	 *
	 * @param androidId the android id
	 * @param sessionAnswerId the session answer id
	 * @param answerId the answer id
	 * @return the session questionary model
	 */
	public SessionQuestionaryModel answerSession(String androidId, Long sessionAnswerId, Long answerId) {
		SessionQuestionaryModel model = null;

		DeviceModel device = deviceService.searchDevice(androidId);
		SessionQuestionaryEntity sessionQuestionaryEntity = sessionQuestionaryRepository.findBySessionId(sessionAnswerId);
		AnswerEntity answerEntity = answerRepository.findByAnswerId(answerId);;
		if (device == null) {
			model = null;
		} else if (sessionQuestionaryEntity == null) {
			model = null;
		} else if (answerEntity == null) {
			model = null;
		} else {
			
			// Comprueba que no tenga otra respuesta
			
			SessionAnswerEntity sessionAnswer = new SessionAnswerEntity();
			sessionAnswer.setSessionCuestionary(sessionQuestionaryEntity);
			sessionAnswer.setQuestionaryId(answerEntity.getQuestion().getQuestionary().getQuestionaryId());
			sessionAnswer.setQuestionId(answerEntity.getQuestion().getQuestionId());
			sessionAnswer.setAnswerId(answerId);
			sessionAnswer = sessionAnswerRepository.save(sessionAnswer);
			
			// Verifica si es el último lo establece automáticamente
			
			model = (SessionQuestionaryModel) sessionQuestionaryConverter.toModel(sessionQuestionaryEntity);
		}
		return model;
	}
	

}