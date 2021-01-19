package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import core.DriverFactory;
import core.ExcelDataProvider;
import core.TestConfig;
import core.TestReports;

public class TestBase {
	
	private WebDriver driver;
	private DriverFactory df;
	private ExcelDataProvider excel;
	private TestReports reports;
	
	@BeforeSuite
	public void initSuite() throws Exception {
		TestConfig.loadProperies(System.getenv("env"));
		reports =  new TestReports();
	}
	
	@DataProvider
	public Object[][] extractData(Method method) throws Exception {
		String tcName = method.getName();
		excel = new ExcelDataProvider(System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx",System.getenv("env").toUpperCase());
		List<HashMap<String,String>> data = excel.getAllData(tcName);
		
		Object[][] dataObj = new Object[data.size()][1];
		for(int i=0; i<data.size(); i++) {
			dataObj[i][0] = data.get(i);
			System.out.println(dataObj[i][0]);
		}
		return dataObj;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void initDriver() throws Exception {
		String browser = System.getenv("browser");
		df = new DriverFactory();
		driver = df.getDriver(browser);
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void tearDown() {
		df.tearDown();
	}*/
	@AfterMethod(alwaysRun=true)
    public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			report().logReport(LogStatus.FAIL, "TEST CASE FAILED IS ",result.getName()); //to add name in extent report
			report().logReport(LogStatus.FAIL, "TEST CASE FAILED IS ",result.getThrowable().getMessage()); //to add error/exception in extent report
			
			//String screenshotPath = FreeCRMTest.getScreenshot(driver, result.getName());
			//extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			report().logReport(LogStatus.SKIP, "Test Case SKIPPED IS ", result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			report().logReport(LogStatus.PASS, "Test Case PASSED IS ", result.getName());

		}
		
		df.tearDown();
		//extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		//driver.quit();
	}
    

	
	@BeforeMethod
	public void initTest(Method method) {
		reports.startReport(method.getName());
	}
	
	@AfterMethod
	public void finishTest() {
		reports.endReport();
	}
	
	public WebDriver driver() {
		return driver;
	}
	
	public TestReports report() {
		return reports;
	}
	
	@AfterSuite
	public void quitSuite() {
		reports.clearReport();
	}

}
