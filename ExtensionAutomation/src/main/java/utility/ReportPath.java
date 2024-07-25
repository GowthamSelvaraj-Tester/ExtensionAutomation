package utility;

import constants.FrameWorkConstants;

public class ReportPath {
	
	public ReportPath() {
	}
	
	public static String getReportPath() {
		
		String report = FrameWorkConstants.EXTENT_REPORT_FOLDERPATH +FrameWorkConstants.EXTENT_REPORT_NAME;
		System.out.println(report);
		return report;
	}

	public static void main(String[] args) {
		getReportPath();
	}
}
