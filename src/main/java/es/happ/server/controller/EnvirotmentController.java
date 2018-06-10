package es.happ.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.happ.server.rest.response.HappEnvirotment;
import es.happ.server.service.DeviceService;
import es.happ.server.service.EnvirotmentService;
import es.happ.server.types.TypeResponse;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/envirotment")
public class EnvirotmentController {
	
	@Autowired
	@Qualifier("envirotmentService")
	private EnvirotmentService envirotmentService;
	
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;

	
	@GetMapping("/educationLevels")
	public ResponseEntity<HappEnvirotment> getAllEducationLevel() {
		HappEnvirotment data = new HappEnvirotment();
		data.setTypeResponse(TypeResponse.OK);
		data.setEducationLevels(envirotmentService.getAllEducationLevel());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
}
