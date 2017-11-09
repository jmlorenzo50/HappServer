package es.happ.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.happ.server.model.DeviceModel;
import es.happ.server.model.ResponseModel;
import es.happ.server.service.DeviceService;
import es.happ.server.types.Gender;
import es.happ.server.types.MaritalStatus;
import es.happ.server.types.MessagesConstans;
import es.happ.server.types.TypeResponse;

/**
 * The Class DeviceController.
 * @version 1.0
 * @author jorge
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/happ/device")
public class DeviceController {
	
	/** The device service. */
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	
	/**
	 * Search.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/search")
	public ResponseEntity<ResponseModel> search(@RequestParam(name="id",required=true) String id) {
		ResponseModel data = new ResponseModel();
		
		DeviceModel device = null; 
		device = deviceService.searchDevice(id);
		if (device != null) {
			data.setTypeResponse(TypeResponse.OK);
			data.setDeviceModel(device);
		} else {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	

	/**
	 * Adds the.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/add")
	public ResponseEntity<ResponseModel> add(@RequestParam(name="id",required=true) String id) {
		ResponseModel data = new ResponseModel();
		
		DeviceModel device = deviceService.searchDevice(id);
		if (device != null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_ADD_BECAUSE_EXIST);
			data.setDeviceModel(device);
		} else {
			device = deviceService.addDevice(id);
			if (device != null) {
				data.setTypeResponse(TypeResponse.OK);
				data.setDeviceModel(device);
			} else {
				data.setTypeResponse(TypeResponse.ERROR);
				data.setError(MessagesConstans.ERROR_DEVICE_NOT_ADD);
			}
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	/**
	 * Adds the.
	 *
	 * @param id the id
	 * @param age the age
	 * @param gender the gender
	 * @return the response entity
	 */
	@GetMapping("/update")
	public ResponseEntity<ResponseModel> add(
						@RequestParam(name="id",required=true) String id,
						@RequestParam(name="age",required=true) int age,
						@RequestParam(name="gender",required=true) String gender,
						@RequestParam(name="maritalstatus",required=true) String maritalStatus,
						@RequestParam(name="codeEducationLevel",required=true) String codeEducationLevel) {
		ResponseModel data = new ResponseModel();
		
		DeviceModel device = deviceService.searchDevice(id);
		if (device == null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError(MessagesConstans.ERROR_DEVICE_NOT_FOUND);
			data.setDeviceModel(device);
		} else {
			device = deviceService.updateDevice(id, 
												age, 
												Gender.valueOf(gender), 
												MaritalStatus.valueOf(maritalStatus), 
												codeEducationLevel);
			
			if (device != null) {
				data.setTypeResponse(TypeResponse.OK);
				data.setDeviceModel(device);
			} else {
				data.setTypeResponse(TypeResponse.ERROR);
				data.setError(MessagesConstans.ERROR_DEVICE_NOT_UPDATE);
			}
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	
	/**
	 * Checks for scheduled task.
	 *
	 * @param androidId the android id
	 * @return the response model
	 */
	@GetMapping("/hasScheduledTask")
	public ResponseModel hasScheduledTask(@RequestParam(name="id",required=true) String androidId) {
		ResponseModel data = new ResponseModel();
		data.setTypeResponse(TypeResponse.OK);
		data.setHasScheduledTask(deviceService.hasScheduledTask(androidId));
		return data;
	}
	
	
}
