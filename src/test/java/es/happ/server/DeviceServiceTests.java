package es.happ.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import es.happ.server.model.DeviceModel;
import es.happ.server.service.DeviceService;

/**
 * DeviceServiceTests
 * @version 1.0
 * @author jorge
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceTests {

	/** The device service. */
	@Autowired
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void searchById() {

		// GIVE
		String id = "6244f1aa4ef72ab5";
		
		// WHEN
		DeviceModel device = deviceService.searchDevice(id);
		
		// THEN
		Assert.notNull(device, "Id:" + id + " not found" );
		
	}


	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void searchByIdError() {

		// GIVE
		String id = "1111122223333";
		
		// WHEN
		DeviceModel device = deviceService.searchDevice(id);
		
		// THEN
		Assert.isNull(device, "Id:" + id + " not found" );
		
	}


}
