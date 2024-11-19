package anujaSeleniumWithJava;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import anujaSeleniumWithJava.AbstractComponents.CheckOutPage;
import anujaSeleniumWithJava.AbstractComponents.ConfirmationPage;
import anujaSeleniumWithJava.pageObjects.LandingPage;
import anujaSeleniumWithJava.pageObjects.ProductCatalogue;
import anujaSeleniumWithJava.pageObjects.cartPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		driver.manage().window().maximize();
		ProductCatalogue pC = lp.loginApplication("annupatil1994@gmail.com", "Anuja@9090");
		List<WebElement> products = pC.getProductList();
		
	//	pC.getProductByName(productName);
		
		pC.addProcuctToCart(productName);
		cartPage cP = pC.goToCartPage();
		Boolean match = cP.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		cP.goToCheckOut();
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		CheckOutPage checkOutPage = pC.goToCheckOutPage();
		checkOutPage.selectCountry("india");
		ConfirmationPage confirmationPage =  checkOutPage.clickOnSubmit();
				
		//List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted"));
		
		//String contry = countries.stream().filter(c->c.getText().equalsIgnoreCase("India")).toString(); 
		
		
		//Actions action = new Actions(driver);
		
	//	action.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		//waitForElementToAppear
		
		
		
		String confirmMsg = confirmationPage.getConfirmantionMsg();
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		
		
		driver.quit();
		
	
		
	}

}
