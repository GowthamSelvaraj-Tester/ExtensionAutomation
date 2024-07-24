package utility;

public class BrowserOSInfo {
	
	private BrowserOSInfo() {
		
	}
	
	public static String getOSBrowserInfo() {
		return OSInfo.getOSInfo()+" "+ BrowserInfo.getBrowserInfo()+" "
				+ BrowserInfo.getBrowserVersionInfo();
	}

}
