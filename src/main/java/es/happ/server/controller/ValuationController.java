package es.happ.server.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.happ.server.rest.response.HappValuation;
import es.happ.server.service.DeviceService;
import es.happ.server.service.ValuationService;
import es.happ.server.types.TypeResponse;
import es.happ.server.util.DateUtil;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/happ/valuation")
public class ValuationController {
	
	@Autowired
	@Qualifier("valuationService")
	private ValuationService valuationService;
	
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;

	@Autowired
	@Qualifier("dateUtil")
	private DateUtil dateUtil;

	
	@GetMapping("/list/{dd}/{mm}/{yyyy}")
	public ResponseEntity<HappValuation> list(@RequestParam(name="id",   required=true) String androidId, 
			                                  @PathVariable(name="dd",   required=true) int day, 
			                                  @PathVariable(name="mm",   required=true) int month,
			                                  @PathVariable(name="yyyy", required=true) int year
			
			) {
		
		Timestamp valuation_date = dateUtil.getInstance(day, month, year);
		
		HappValuation data = new HappValuation();
		data.setTypeResponse(TypeResponse.OK);
		data.setValuationModels(valuationService.list(androidId, valuation_date));
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("/wellness/{valueGood}/{valueBad}")
	public ResponseEntity<HappValuation> wellness(@RequestParam(name="id",         required=true) String androidId, 
			                                      @PathVariable(name="valueGood",  required=true) int valueGood, 
			                                      @PathVariable(name="valueBad",   required=true) int valueBad
			
			) {
		
		Timestamp timestamp = dateUtil.now();
		
		HappValuation data = new HappValuation();
		data.setTypeResponse(TypeResponse.OK);
		if (!valuationService.wellness(androidId, timestamp, valueGood, valueBad)) {
			data.setTypeResponse(TypeResponse.ERROR);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	

	@GetMapping("/add")
	public ResponseEntity<HappValuation> wellness(@RequestParam(name="id",    required=true) String androidId, 
												  @RequestParam(name="text",  required=true) String text
			) {
		Timestamp timestamp = dateUtil.now();
		
		HappValuation data = new HappValuation();
		data.setTypeResponse(TypeResponse.OK);
		
		byte[] data64 = Base64.getDecoder().decode(text);
		String baseNormal = new String(data64);

		if (!valuationService.add(androidId, timestamp, baseNormal)) {
			data.setTypeResponse(TypeResponse.ERROR);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	
	
}
