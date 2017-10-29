package es.happ.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.ResponseModel;
import es.happ.server.service.DeviceService;
import es.happ.server.service.QuestionayService;
import es.happ.server.types.MessagesConstans;
import es.happ.server.types.TypeResponse;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/happ/questionary")
public class QuestionayController {
	
	@Autowired
	@Qualifier("questionayService")
	private QuestionayService questionayService;
	
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;

	
	@GetMapping("/all")
	public ResponseModel getAllQuestionaries() {
		ResponseModel data = new ResponseModel();
		data.setTypeResponse(TypeResponse.OK);
		data.setQuestionary(questionayService.getAllQuestionaries());
		return data;
	}
	
	@GetMapping("/session/new")
	public ResponseModel createNewSession(@RequestParam(name="id",required=true) String androidId) {
		ResponseModel data = new ResponseModel();
		if (deviceService.searchDevice(androidId) == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		} else {
			data.setTypeResponse(TypeResponse.OK);
			data.setSessionQuestionary(questionayService.createNewSession(androidId));
		}
		return data;
	}
	
	@GetMapping("/session/forAnswer")
	public ResponseModel forAnswer(@RequestParam(name="id",required=true) String androidId) {
		ResponseModel data = new ResponseModel();
		if (deviceService.searchDevice(androidId) == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		} else {
			data.setTypeResponse(TypeResponse.OK);
			data.setFirstSessionQuestionary(questionayService.findFirstSessionByAndroidId(androidId));
			
			if (data.getFirstSessionQuestionary() != null) {
				Long questionaryId = data.getFirstSessionQuestionary().getSessionId();
				QuestionaryModel qm = questionayService.findQuestionary(questionaryId);
				List<QuestionaryModel> list = new ArrayList<>();
				list.add(qm);
				data.setQuestionary(list);
			}
		}
		return data;
	}
	
	
	
	
	@GetMapping("/session/answer")
	public ResponseModel answerSession(
			@RequestParam(name="id",required=true) String androidId,
			@RequestParam(name="session",required=true) Long sessionAnswerId,
			@RequestParam(name="answer",required=true) Long answerId) {
		ResponseModel data = new ResponseModel();
		if (deviceService.searchDevice(androidId) == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		} else if (questionayService.findSession(sessionAnswerId) == null) {	
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_SESSION_NOT_FOUND);
		} else {
			data.setTypeResponse(TypeResponse.OK);
			data.setSessionQuestionary(questionayService.answerSession(androidId, sessionAnswerId, answerId));
			if (data.getSessionQuestionary() == null) {
				data.setTypeResponse(TypeResponse.ERROR);
				data.setError(MessagesConstans.ERROR_QUESTION_NOT_ANSWER);
			}
		}
		return data;
	}
	
}
