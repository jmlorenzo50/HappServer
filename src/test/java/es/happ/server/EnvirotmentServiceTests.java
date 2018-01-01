package es.happ.server;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import es.happ.server.model.EducationLevelModel;
import es.happ.server.service.EnvirotmentService;

/**
 * DeviceServiceTests
 * @version 1.0
 * @author jorge
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvirotmentServiceTests {

	@Autowired
	@Qualifier("envirotmentService")
	private EnvirotmentService envirotmentService;
	
	/**
	 * Search by id OK
	 */
	@Test
	@Transactional
	public void educationLevels() {
		// GIVE
		
		// WHEN
		List<EducationLevelModel> educationLevels = envirotmentService.getAllEducationLevel();
		
		// THEN
		Assert.notNull(educationLevels, "EducationLevels not found" );
	}

}
