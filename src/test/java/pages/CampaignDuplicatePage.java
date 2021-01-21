package pages;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.CampaignElements;
import pages.BasePage;
import tests.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
public class CampaignDuplicatePage  {
	private WebDriver driver;

	@FindBy(xpath="//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]/div/div[2]")
	private WebElement SenderId;   // driver.findElement(By.xpath())
	
	public WebDriverWait wait;

	public CampaignDuplicatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void DuplicateEdit(String Senderid) throws InterruptedException{

		Thread.sleep(2000);	  
		//Select the dropdown
		BasePage.waitForElement(driver,CampaignElements.Dropdown,50);
		BasePage.ClickElement(driver,CampaignElements.Dropdown);

		//Select duplicate option
		BasePage.waitForElement(driver,CampaignElements.Dup,50);
		BasePage.ClickElement(driver,CampaignElements.Dup);
		//Confimr Duplicate
		BasePage.waitForElement(driver,CampaignElements.DupConfirm1,50);

		BasePage.ClickElement(driver,CampaignElements.DupConfirm1);
		//BasePage.performScrollToElement(driver, CampaignElements.Dupconfirm2);
		BasePage.waitForElement(driver,CampaignElements.Dupconfirm2,50);

		BasePage.ClickElement(driver,CampaignElements.Dupconfirm2);

		Thread.sleep(2000);
		//Click edit from dropdown
		BasePage.waitForElement(driver,CampaignElements.Dropdown,50);
		BasePage.ClickElement(driver,CampaignElements.Dropdown);

		BasePage.waitForElement(driver,CampaignElements.EditDup,50);
		BasePage.ClickElement(driver,CampaignElements.EditDup);
		//Select sender id 
		BasePage.performScrollToElement(driver,SenderId);

		Thread.sleep(2000);	
		WebElement sendidselct = driver.findElement(By.xpath("//*[@id='app']/div/section/div[2]/div[1]/div/div[1]/form/div[4]/div[1]/div/div[2]"));
		Actions builder = new Actions(driver);
		System.out.println("Sender Id"+Senderid);
		builder.moveToElement(sendidselct).sendKeys(sendidselct,Senderid).
		sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//Select Choose contact form wizard
		BasePage.waitForElement(driver,CampaignElements.ChooseContactstage,30);
		BasePage.ClickElement(driver,CampaignElements.ChooseContactstage);
		//Select list	
		BasePage.waitForElement(driver,CampaignElements.SelectList,30);
		BasePage.ClickElement(driver,CampaignElements.SelectList);
		//Save contacts
		BasePage.waitForElement(driver,CampaignElements.Continuebtn,30);
		BasePage.ClickElement(driver,CampaignElements.Continuebtn);
		//schedule 
		BasePage.waitForElement(driver,CampaignElements.schedule,50);
		BasePage.ClickElement(driver,CampaignElements.schedule);
		System.out.println("Campaign Scheduled Successfully");

	}

	public void Schedule(String time) throws InterruptedException {

		BasePage.waitForElement(driver,CampaignElements.schedTime,50);
		Thread.sleep(1000);
		BasePage.clear(driver,CampaignElements.schedTime);
		Thread.sleep(1000);
		BasePage.ClickElement(driver,CampaignElements.schedTime);
		Thread.sleep(1000);
		BasePage.EnterText(driver,CampaignElements.schedTime,time);
	}
	public void Scheduleconfirm() throws InterruptedException  {
		try {
			BasePage.waitForElement(driver,CampaignElements.schedconfirm,50);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,CampaignElements.schedconfirm);
			Thread.sleep(1000);

			BasePage.waitForElement(driver,CampaignElements.closeSuccessmessage,50);
			Thread.sleep(1000);
			BasePage.ClickElement(driver,CampaignElements.closeSuccessmessage);

		}
		catch(Exception e) {
			System.out.println(e);
			Thread.sleep(1000);
			BasePage.waitForElement(driver, CampaignElements.scheduleclosebutton, 25);
			System.out.println("trying to close the time windoe");
			BasePage.ClickElement(driver, CampaignElements.scheduleclosebutton);
			Thread.sleep(1000);
			BasePage.waitForElement(driver, CampaignElements.camaignpreviewclose, 25);
			BasePage.ClickElement(driver, CampaignElements.camaignpreviewclose);
			System.out.println("trying to close the camp windoe");
		}


	}


}


