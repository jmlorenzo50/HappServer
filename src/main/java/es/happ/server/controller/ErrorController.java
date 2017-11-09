package es.happ.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Error Controller
 * @version 1.0
 * @author jorge
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class ErrorController {
	
	/**
	 * get error
	 * @return Error
	 */
	@GetMapping("/error")
	public ResponseEntity<String> error() {
		String error = "Error en la petición"; 
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
}
