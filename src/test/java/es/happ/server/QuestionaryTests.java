package es.happ.server;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import es.happ.server.model.AnswerModel;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.QuestionModel;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.ScheduledTaskQuestionaryModel;
import es.happ.server.service.DeviceService;
import es.happ.server.service.QuestionaryService;

/**
 * DeviceServiceTests
 * @version 1.0
 * @author jorge
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionaryTests {

	@Autowired
	@Qualifier("questionaryService")
	private QuestionaryService questionaryService;
	
	/** The device service. */
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	/**
	 * Android identification
	 */
	private static String androidId;
	
	@BeforeClass
	public static void init() {
		androidId = "test" + new Date().getTime();
	}
	
	
	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void getAllQuestionaries() {
		// GIVE
		
		// WHEN
		List<QuestionaryModel> questionaries = questionaryService.getAllQuestionaries();
		
		// THEN
		Assert.notNull(questionaries, "Questionaries not found" );
	}


	@Test
	@Transactional
	public void findFirstSessionByAndroidId() {
		// GIVE
		DeviceModel deviceModel = deviceService.addDevice(androidId);
				 
		// WHEN
		ScheduledTaskQuestionaryModel firstSessionQuestionary = questionaryService.findFirstSessionByAndroidId(deviceModel);
		
		// THEN
		Assert.notNull(firstSessionQuestionary, "Session of questionary not found" );
		
	}

	@Test
	@Transactional
	public void findQuestionary() {
		// GIVE
		DeviceModel deviceModel = deviceService.addDevice(androidId);
		ScheduledTaskQuestionaryModel sessionQuestionary = questionaryService.findFirstSessionByAndroidId(deviceModel);
		
		// WHEN
		QuestionaryModel questionary = questionaryService.findQuestionary(sessionQuestionary.getQuestionaryId());
		
		// THEN
		Assert.notNull(questionary, "Questionary not found" );
		
	}

	@Test
	@Transactional
	@Ignore
	public void answerSession() {
		// GIVE
		DeviceModel deviceModel = deviceService.addDevice(androidId);
		ScheduledTaskQuestionaryModel sessionQuestionary = questionaryService.findFirstSessionByAndroidId(deviceModel);
		QuestionaryModel questionary = questionaryService.findQuestionary(sessionQuestionary.getQuestionaryId());
		Assert.notNull(questionary, "Questionary not found" );
		
		// WHEN
		List<QuestionModel> questions = questionary.getQuestions();
		Assert.notNull(questions, "Questions not found" );
		
		ScheduledTaskQuestionaryModel scheduledTaskQuestionaryModel = null;
		for (QuestionModel questionModel : questions) {
			AnswerModel answer = questionModel.getAnswers().get(0);
			Assert.notNull(questions, "Answers not found" );
			
			scheduledTaskQuestionaryModel = questionaryService.answerSession(androidId,  sessionQuestionary.getQuestionaryId(), answer.getAnswerId());
		}
		
		// THEN
		Assert.notNull(scheduledTaskQuestionaryModel.getFinishedDate(), "Scheduled Task for a questionary is not end" );
	}

	
}
