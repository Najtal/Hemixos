package properties;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

		
	public static final String MAIN_PROPERTIES = "res/prop/config.properties";
	public static final String LANG_PROPERTIES = "_language.properties";
	
	public static final String LANGUAGE_REP = "res/languages/";

	
	public Properties loadProperties(String fileName) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);
		fis.close();
		
		return prop;
	}

	
}
