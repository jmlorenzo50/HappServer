package es.happ.server;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import es.happ.server.model.EducationLevelModel;
import es.happ.server.model.ValuationModel;
import es.happ.server.service.EnvirotmentService;
import es.happ.server.service.ValuationService;
import es.happ.server.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * DeviceServiceTests.
 *
 * @author jorge
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValuationServiceTests {

	/** The valuation service. */
	@Autowired
	@Qualifier("valuationService")
	private ValuationService valuationService;
	
	/** The date util. */
	@Autowired
	@Qualifier("dateUtil")
	private DateUtil dateUtil;
	
	/** Android identification. */
	private static String androidId;
	
	
	/**
	 * Inits the test.
	 */
	@BeforeClass
	public static void init() {
		androidId = "6244f1aa4ef72ab5";
	}
	
	
	/**
	 * Search by id OK.
	 */
	@Test
	@Transactional
	public void valuationsExist() {
		// GIVE
		Timestamp valuation_date = dateUtil.getInstance(21, 1, 2018);
		
		// WHEN
		List<ValuationModel> valuations = valuationService.list(androidId, valuation_date);
		
		// THEN
		Assert.notNull(valuations, "ValuationModel not found" );
	}

}
