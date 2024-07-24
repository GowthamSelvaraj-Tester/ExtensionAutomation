package factories;
import driver.DriverManagerChrome;
import driver.DriverManagerEdge;
import driver.DriverManagerFireFox;
import driver.DriverManager_OC;
import enums.DriverType;

public class DriverManagerFactory {
	
	public static DriverManager_OC getManager(DriverType driver) {
		
		switch(driver) {
		
			case CHROME: {
				return new DriverManagerChrome();
			} 
			case FIREFOX: {
				return new DriverManagerFireFox();
			}
			case EDGE: {
				return new DriverManagerEdge();
			}
			default: throw new IllegalArgumentException("Invalid Driver: "+ driver);
		}
	}
}
