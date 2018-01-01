package es.happ.server.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * The Class DateUtil.
 */
@Component("dateUtil")
public class DateUtil {
	
	/**
	 * Now.
	 *
	 * @return the timestamp
	 */
	public Timestamp now() {
		return new Timestamp(new Date().getTime());
	}
	
	
	/**
	 * Now add month.
	 *
	 * @param number the number
	 * @return the timestamp
	 */
	public Timestamp nowAddMonth(int number) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now());
		cal.add(Calendar.MONTH, number);
		return new Timestamp(cal.getTime().getTime());
	}


	/**
	 * Now add month.
	 *
	 * @param number the number
	 * @return the timestamp
	 */
	public Timestamp nowAddDay(int number) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now());
		cal.add(Calendar.DAY_OF_YEAR, number);
		return new Timestamp(cal.getTime().getTime());
	}

}
