package tests;
import java.lang.*;

import java.io.IOException;
import java.util.HashMap;

import org.apache.xmlbeans.impl.regex.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.TestConfig;
import core.TestReports;
import pages.CampaignPage;

import pages.LoginPage;

import pages.LogoutPage;

public class BulkCampaign extends TestBase{
	LoginPage login;
	
	CampaignPage campaign;
	@BeforeMethod
	public void Login_To_App() throws Exception {
		Thread.sleep(1000);
		
		driver().get(TestConfig.getProperty("APP_URL"));
	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_Bulk_Campaign(HashMap<String,String> data) throws ParseException, IOException, InterruptedException, Exception {
		System.out.println("Hello");
		login = new LoginPage(driver());
		Thread.sleep(1000);
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Username", data.get("username"));
		report().logReport(LogStatus.INFO, "Password", data.get("password"));
		
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		System.out.println("Launched driver Successufflu");
		
		campaign = new CampaignPage(driver());
		campaign.getSenderId(data.get("senderid1"),data.get("senderid2"),data.get("senderid3"),data.get("senderid4"),data.get("senderid5"));
		campaign.Bulk_campaign1(data.get("usercount"));
		
		
		/*if(campaign.Verify_Bulk_campaign(data.get("UserCount")) == true) {
			report().logReport(LogStatus.PASS, "View No  Error status", 
					"View No Error status displayed successfully");
		}else {
			report().logReport(LogStatus.FAIL, "View No  Error status", 
					"View No Error status didnt displayed");
		}
	}      
	*/
	
	
	
	

		
		
		
}
}
