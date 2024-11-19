package anujaSeleniumWithJava.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	/*
	 * 		String confirmMsg = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	 */
	
	@FindBy (css = "h1[class='hero-primary']")
	public WebElement text;
	
	public String getConfirmantionMsg() {
		
		return text.getText();
	}
}
