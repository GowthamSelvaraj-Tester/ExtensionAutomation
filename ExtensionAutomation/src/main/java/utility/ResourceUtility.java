package utility;

public class ResourceUtility {
	public static String getFolderPath(){
		return GlobalVariable.basepath+ConfigReaders.getProperty("sheetPath");
	}
		
	public static String getScreenshotPath() {
		return GlobalVariable.basepath+ConfigReaders.getProperty("screenShotFolderPath");
	}
}
