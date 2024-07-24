package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

public class ConfigReaders {
	private static LinkedList<String> configFilePaths = new LinkedList<>();
		
	static {
		configFilePaths.add(GlobalVariables.basepath+"//config.properties");
		configFilePaths.add(GlobalVariables.basepath+"//dataProviders.properties");
	}
		
	public static String getProperty(String ConfigKey) {
		Properties prop = new Properties();
		String configValue = null;
		try {
			for(String filePath: configFilePaths) {
				try(InputStream input = new FileInputStream(filePath)) {
					prop.load(input);
					configValue = prop.getProperty(ConfigKey);
					if(configValue !=null) {
						break;
					}
				} catch(Exception e) {
						e.printStackTrace();
				}
			}
		} catch(Exception e) {
				e.printStackTrace();
		}	
		return configValue;
	}
}
