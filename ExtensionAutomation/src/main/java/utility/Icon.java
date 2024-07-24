package utility;


import constants.FrameWorkConstants;

public final class Icon {
	
	private Icon() {
		
	}
	public static String getBrowserIcon() {
		String browserInLowerCase = BrowserInfo.getBrowserInfo().toLowerCase();
		if (browserInLowerCase.contains(FrameWorkConstants.ICON_BROWSER_CHROME)) {
			return FrameWorkConstants.ICON_BROWSER_PREFIX +FrameWorkConstants.ICON_BROWSER_CHROME + FrameWorkConstants.ICON_BROWSER_SUFFIX;
			//return "<i class='fa-brands fa-edge'></i>";
		} else {
			return FrameWorkConstants.ICON_BROWSER_PREFIX + browserInLowerCase + FrameWorkConstants.ICON_BROWSER_SUFFIX;
		}
	}
	
	public static String getOSIcon() {

		String operSys = OSInfo.getOSInfo().toLowerCase();
		if (operSys.contains("win")) {
			return FrameWorkConstants.ICON_OS_WINDOWS;
		} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
			return FrameWorkConstants.ICON_OS_LINUX;
		} else if (operSys.contains("mac")) {
			return FrameWorkConstants.ICON_OS_MAC;
		}
		return operSys;
	}

}
