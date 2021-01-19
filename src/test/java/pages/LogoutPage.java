package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {
	// Locators
	@FindBy(xpath="//li[@class='nav-item']/a[@id='popover-profile']")
	private WebElement accntSettings;   // driver.findElement(By.xpath())
	
	@FindBy(xpath="//ul[@class='nav-user-drop']/li[10]/a")
	private WebElement LogoutOption;
	
	@FindBy(xpath="//h1[@class='text-center mb-4 font-weight-normal display-1']")
	private WebElement LoginRedirected;
	
	private WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Business logic
	public void peformLogout() {
		
		
		System.out.println("Entering Logout");
		BasePage.waitForElement(driver,accntSettings,25);
		BasePage.moveToElement(driver,accntSettings);
		BasePage.ClickElement(driver,accntSettings);
  	    
		BasePage.waitForElement(driver,LogoutOption,25);
		BasePage.ClickElement(driver,LogoutOption);
  	    
		BasePage.waitForElement(driver,LoginRedirected,25);
  	  
  	   // driver.navigate().to("http://dash.vinmail.io/autologin");
	}

		
	

}
