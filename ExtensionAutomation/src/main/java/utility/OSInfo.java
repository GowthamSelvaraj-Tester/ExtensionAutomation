package utility;

public class OSInfo {

	private OSInfo() {
		
	}
	
	public static String getOSInfo() {
		return System.getProperty("os.name");
	}
}
