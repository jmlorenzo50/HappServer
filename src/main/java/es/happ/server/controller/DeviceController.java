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
import es.happ.server.types.TypeResponse;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/happ/device")
public class DeviceController {
	
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	
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
			data.setError("Device not found");
		}
		return new ResponseEntity<ResponseModel>(data, HttpStatus.OK);
	}
	

	@GetMapping("/add")
	public ResponseEntity<ResponseModel> add(@RequestParam(name="id",required=true) String id) {
		ResponseModel data = new ResponseModel();
		
		DeviceModel device = deviceService.searchDevice(id);
		if (device != null) {
			data.setTypeResponse(TypeResponse.ERROR);
			data.setError("The device can not be added because it is already registered");
			data.setDeviceModel(device);
		} else {
			device = deviceService.addDevice(id);
			if (device != null) {
				data.setTypeResponse(TypeResponse.OK);
				data.setDeviceModel(device);
			} else {
				data.setTypeResponse(TypeResponse.ERROR);
				data.setError("The device can not be added and we don't know the cause");
			}
		}
		return new ResponseEntity<ResponseModel>(data, HttpStatus.OK);
	}
	
	
	
}
