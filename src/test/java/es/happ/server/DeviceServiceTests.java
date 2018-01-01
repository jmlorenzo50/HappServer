package es.happ.server;

import java.util.Date;

import org.junit.BeforeClass;
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
import es.happ.server.types.Gender;
import es.happ.server.types.MaritalStatus;

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
	public void searchById() {
		// GIVE
		deviceService.addDevice(androidId);
		
		// WHEN
		DeviceModel device = deviceService.searchDevice(androidId);
		
		// THEN
		Assert.notNull(device, "Id:" + androidId + " not found" );
		
	}


	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void searchByIdError() {
		// GIVE
		
		// WHEN
		DeviceModel device = deviceService.searchDevice(androidId);
		
		// THEN
		Assert.isNull(device, "Id:" + androidId + " exist" );
		
	}
	
	
	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void updateByIdError() {
		// GIVE
		deviceService.addDevice(androidId);
		int age = 21;
		Gender gender = Gender.MAN;
		MaritalStatus maritalStatus = MaritalStatus.MARRIED;
		String codeEducationLevel = "BAS"; 
		
		// WHEN
		DeviceModel device = deviceService.updateDevice(androidId, age, gender, maritalStatus, codeEducationLevel);
		
		// THEN
		Assert.notNull(device, "Id:" + androidId + " not found" );
		
	}
	
	/**
	 * Add device time test 
	 */
	@Test
	@Transactional
	public void addDevice() {
		// GIVE
		
		// WHEN
		DeviceModel device = deviceService.addDevice(androidId);
		
		// THEN
		Assert.notNull(device, "Id:" + androidId + " not found" );
		
	}

	/**
	 * Add device time test 
	 */
	@Test
	@Transactional
	public void addDeviceError() {
		// GIVE
		deviceService.addDevice(androidId);
		
		// WHEN
		DeviceModel device = deviceService.addDevice(androidId);
		
		// THEN
		Assert.isNull(device, "Id:" + androidId + " exist");
	}


	/**
	 * Add device time test 
	 */
	@Test
	@Transactional
	public void hasScheduledTask() {
		// GIVE
		deviceService.addDevice(androidId);
		
		// WHEN
		boolean hasScheduledTask = deviceService.hasScheduledTask(androidId);
		
		// THEN
		Assert.isTrue(hasScheduledTask, "The android device " + androidId + " hasn't scheduled task ");
	}


	/**
	 * Add device time test 
	 */
	@Test
	@Transactional
	public void hasScheduledTaskError() {
		// GIVE
		
		// WHEN
		boolean hasScheduledTask = deviceService.hasScheduledTask(androidId);
		
		// THEN
		Assert.isTrue(!hasScheduledTask, "The android device " + androidId + " has scheduled task ");
	}
	
}
