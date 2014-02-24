package util;

import java.util.GregorianCalendar;

public class TimeUtil {

	
	public static long differenceBetween(GregorianCalendar g1, GregorianCalendar g2) {
		return g1.getTimeInMillis()-g2.getTimeInMillis();
	}
	
}
