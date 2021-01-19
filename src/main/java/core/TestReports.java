package core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestReports {
	
	private ExtentReports report;
	private ExtentTest test;
	
	public TestReports() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dt = sdf.format(cal.getTime()).replace(" ","_").replace(":","_");
		report = new ExtentReports("./TestReports_"+dt+".html",false);
	}
	
	public void startReport(String testName) {
		test = report.startTest(testName);
	}
	
	public void logReport(LogStatus status, String testStep, Throwable throwable ) {
		test.log(status, testStep, throwable);
	}
	public void logReport(LogStatus status, String testStep, String testresult ) {
		test.log(status, testStep, testresult);
	}
	
	public void endReport() {
		report.endTest(test);
	}
	
	public void clearReport() {
		report.flush();
		report.close();
	}

}
