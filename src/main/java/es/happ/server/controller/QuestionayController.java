package es.happ.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.happ.server.model.DeviceModel;
import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.HappQuestionary;
import es.happ.server.service.DeviceService;
import es.happ.server.service.QuestionaryService;
import es.happ.server.types.MessagesConstans;
import es.happ.server.types.TypeResponse;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/questionary")
public class QuestionayController {
	
	@Autowired
	@Qualifier("questionaryService")
	private QuestionaryService questionaryService;
	
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;

	@GetMapping("/all")
	public HappQuestionary getAllQuestionaries() {
		HappQuestionary data = new HappQuestionary();
		data.setTypeResponse(TypeResponse.OK);
		data.setQuestionary(questionaryService.getAllQuestionaries());
		return data;
	}
	
	@GetMapping("/session/forAnswer")
	public HappQuestionary forAnswer(@RequestParam(name="id",required=true) String androidId) {
		HappQuestionary data = new HappQuestionary();
		DeviceModel deviceModel = deviceService.searchDevice(androidId);
		if (deviceModel == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		} else {
			data.setTypeResponse(TypeResponse.OK);
			data.setFirstSessionQuestionary(questionaryService.findFirstSessionByAndroidId(deviceModel));
			
			if (data.getFirstSessionQuestionary() != null) {
				Long questionaryId = data.getFirstSessionQuestionary().getQuestionaryId(); //TODO el id esta mal, no es el del cuestionario
				QuestionaryModel qm = questionaryService.findQuestionary(questionaryId);
				List<QuestionaryModel> list = new ArrayList<>();
				list.add(qm);
				data.setQuestionary(list);
			}
		}
		return data;
	}
	
	@GetMapping("/session/answer")
	public HappQuestionary answerSession(
			@RequestParam(name="id",required=true) String androidId,
			@RequestParam(name="session",required=true) Long sessionAnswerId,
			@RequestParam(name="answer",required=true) Long answerId) {
		HappQuestionary data = new HappQuestionary();
		if (deviceService.searchDevice(androidId) == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		/*} else if (questionaryService.findFirstSessionByAndroidId(sessionAnswerId) == null) {	
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_SESSION_NOT_FOUND);*/
		} else {
			data.setTypeResponse(TypeResponse.OK);
			data.setSessionQuestionary(questionaryService.answerSession(androidId, sessionAnswerId, answerId));
			if (data.getSessionQuestionary() == null) {
				data.setTypeResponse(TypeResponse.ERROR);
				data.setError(MessagesConstans.ERROR_QUESTION_NOT_ANSWER);
			}
		}
		return data;
	}
	
}
