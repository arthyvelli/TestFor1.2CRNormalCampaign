package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
	
	//private static File resource = new File("/src/test/resources");
	private static Properties property;
	
	public static void loadProperies(String envName) throws Exception {
		property = new Properties();
		property.load(new FileInputStream(new File("src/test/resources/config."+envName+".properties")));
	}
	
	public static String getProperty(String key) {
		if(property.containsKey(key)) {
			return property.getProperty(key);
		}
		return null;
	}

}
