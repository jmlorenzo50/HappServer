package es.happ.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class ErrorController {
	
	@GetMapping("/error")
	public ResponseEntity<String> error() {
		String error = "Error en la petición"; 
		return new ResponseEntity<String>(error, HttpStatus.OK);
	}
	
}
