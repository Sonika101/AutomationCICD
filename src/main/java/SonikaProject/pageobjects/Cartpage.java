package SonikaProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SonikaProject.AbstractComponent.AbstractComponent;


public class Cartpage extends AbstractComponent{
	
	WebDriver driver;
	
	public Cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> itemCarts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutBtn;
	
	public Boolean itemsInCart(String productName )
	{
		Boolean itemCart=itemCarts.stream().anyMatch(iCart->iCart.getText().equalsIgnoreCase(productName));
		return itemCart;
	}
	
	public void geToCheckoutPage()
	{
		
		checkoutBtn.click();
		
	}
	
	
	
	
	
	
	

}
