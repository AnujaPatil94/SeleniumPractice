package anujaSeleniumWithJava.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anujaSeleniumWithJava.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // this willl initialize all the web elemetns and assigne to driver
	}
			
	//List<WebElement> cartProducts =  driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type"); //.btn.w-10.rounded
	By toastMsg = By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) 
	{
		
		WebElement prod =	getProductList().stream().filter(q->
		q.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProcuctToCart(String productName) throws InterruptedException 
	{
		//driver.findElement(By.cssSelector(".totalRow button")).click();'
		WebElement prod = getProductByName(productName);
		prod.findElement(addTocart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
		
		
	}


}
