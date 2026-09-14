package SonikaProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SonikaProject.AbstractComponent.AbstractComponent;


public class ProductCataloguePage extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> allproducts;
	
	By productBy=By.cssSelector(".mb-3");
	By cartButton=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("toast-container");
	
	
	
	public List<WebElement> getProductList()
	{
		elementToBeVisible(productBy);
		return allproducts;
	}
	
	public WebElement addProductByname(String productName )
	{
		WebElement prod=getProductList().stream().filter(allproduct-> 
		allproduct.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public Cartpage addToCart(String productName) throws InterruptedException
	{
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebElement prod=addProductByname(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		elementToDisappear(toastmessage);
		cartButton();
		Cartpage cartpage=new Cartpage(driver);
		return cartpage;
		
	}
	
	

}
