package util;

public class StringTransform {

	
	
	public static String milliSecToString(long mils) {
				
		mils = mils/1000;
		
		int minutes = (int) (mils/60);
		
		if (minutes < 60) {
			int secondes = (int) (mils%60);
		
			String sMinutes = minutes + "";
			String sSecondes = secondes + "";
		
			if (secondes < 10) {
				sSecondes = "0" + secondes;
			}
			
			return sMinutes + ":" + sSecondes;

		} else {
				int heures = minutes/60;
				minutes = minutes%60;
				int secondes = minutes%60;
				
				String sHeures= heures + "";
				String sMinutes = minutes + "";
				String sSecondes = secondes + "";
				
				if (secondes < 10) {
					sSecondes = "0" + secondes;
				}
				
				if (minutes < 10) {
					sMinutes = "0" + minutes;
				}
				
				return sHeures + ":" + sMinutes + ":" + sSecondes;
		}
		
		
	}
	
}
