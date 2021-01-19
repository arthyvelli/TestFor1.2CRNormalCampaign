package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	public static void setText(WebDriver driver,String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static void selectValue(WebElement select, String value) {
		Select sel = new Select(select);
		sel.selectByValue(value);
	}
	
	public static void setText(WebDriver driver,By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void setText(WebDriver driver,WebElement ele, String text) {
		ele.sendKeys(text);
	}
	public static void click(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void click(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	
	public static String grabText(WebDriver driver,String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static void selectOption(WebElement ele,String text) {
		Select sel = new Select(ele);
		sel.selectByValue(text);
	}



public static void ClickElement(WebDriver driver,String locator){
	driver.findElement(By.xpath(locator)).click();
}
public static void ClickElement(WebDriver driver,WebElement ele){
	ele.click();
}
public static void EnterText(WebDriver driver,String locator,CharSequence text ) {
	driver.findElement(By.xpath(locator)).sendKeys(text);
}
/*public static void waitForXpath(WebDriver driver,String locator){
	WebDriverWait wait=new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
}*/

public static void moveToElement(WebDriver driver,String locator) {
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
}

public static void moveToElement(WebDriver driver,WebElement ele) {
	Actions action=new Actions(driver);
	action.moveToElement(ele).build().perform();
}
public static void clear(WebDriver driver,String locator) {
	driver.findElement(By.xpath(locator)).clear();
}
public static WebElement waitForElement(WebDriver driver,String locator, long timeout) { // 25 
	return new WebDriverWait(driver,timeout)
	.ignoring(NoSuchElementException.class)
	.pollingEvery(Duration.ofSeconds(1))
	.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
}
/*
public static void waitForAlert(WebDriver driver, long timeout) { // 25 
	new WebDriverWait(driver,timeout)
	.ignoring(NoSuchElementException.class)
	.pollingEvery(Duration.ofSeconds(1))
	.until(ExpectedConditions.alertIsPresent());
}
*/
  public static void performScrollToElement(WebDriver driver, String locator) { 
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  locator);
}
  
  public static void performScrollToElement(WebDriver driver, WebElement ele) { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  ele);
	}



	
	public static WebElement waitForElement(WebDriver driver,WebElement ele, long timeout) { // 25 
		return new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForAlert(WebDriver driver, long timeout) { // 25 
		new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.alertIsPresent());
	}
/*	
	public static void performScrollToElement(WebDriver driver, WebElement element) { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	*/

}
