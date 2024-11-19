package anujaSeleniumWithJava.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anujaSeleniumWithJava.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // this willl initialize all the web elemetns and assigne to driver
	}
			
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail")); this step is covered in following and in pagefactory initElements
	@FindBy(css="#userEmail") // no need to assign driver every time u create a webelement to accesss the driver
	WebElement userEmail;
	
	@FindBy(css="#userPassword")
	WebElement passWordEle;
	
	@FindBy(css="#login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		passWordEle.sendKeys(password);
		submit.click();
		ProductCatalogue pC = new ProductCatalogue(driver);
		return pC;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
