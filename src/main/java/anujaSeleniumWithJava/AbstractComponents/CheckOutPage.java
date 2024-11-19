package anujaSeleniumWithJava.AbstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponents{
	
	
	WebDriver driver;
		
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");
	
	//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		@FindBy(css=".btnn.action__submit.ng-star-inserted") 
		WebElement submit;
		
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
	@FindBy(css="input[placeholder='Select Country']") 
	WebElement country;
	
	
	//List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted"));
/*	@FindBy (css = ".ta-results.list-group.ng-star-inserted")
	private List<WebElement> countries;  */
	
	//driver.findElement(By.xpath("//button[contains (@class,'ng-star-inserted')][2]")).click();
	@FindBy (xpath = "//button[contains (@class,'ng-star-inserted')][2]")
	private WebElement selectContryI; 
	
	By results = By.cssSelector(".ta-results.list-group.ng-star-inserted");
	
	
	//String contry = countries.stream().filter(c->c.getText().equalsIgnoreCase("India")).toString();
	
	public void selectCountry(String countryName) {
		Actions action = new Actions(driver);
		
		action.sendKeys(country, countryName).build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		waitForElementToAppear(By.cssSelector(".ta-results"));
		//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		selectContryI.click();
	}
	
		
	public ConfirmationPage clickOnSubmit() {
		submit.click();
		return new ConfirmationPage(driver);
	}
}
