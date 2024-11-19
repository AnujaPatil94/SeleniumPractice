package anujaSeleniumWithJava.AbstractComponents;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anujaSeleniumWithJava.pageObjects.cartPage;

public class AbstractComponents {
		
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	@FindBy (css = "[routerlink*='cart']")
	public WebElement cartHeader;
	
		public void waitForElementToAppear(By findBy) 
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		}
		public cartPage goToCartPage() {
			cartHeader.click();
			cartPage cP = new cartPage(driver);
			return cP;
		}
		public void waitForElementToDisappear(WebElement ele) throws InterruptedException 
		{	
			Thread.sleep(1000);
			//As following code is waiting to invisible the button which is taking time to load as there is big traffic on website to handle.
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.invisibilityOf(ele));

		}
		public CheckOutPage goToCheckOutPage() {
			CheckOutPage checkOutPage = new CheckOutPage(driver);
			return checkOutPage;
			
		}
			
}
