package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;



public class LoginPage extends BasePage{

	// Locators
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;   // driver.findElement(By.xpath())
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnLogin;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Business logic
	public void peformLogin(String userName,String password) {
		
		System.out.println(userName);
		this.username.sendKeys(userName);
		System.out.println(password);
		
		this.password.sendKeys(password);
		btnLogin.click();
	}
	
	
	
	
}
