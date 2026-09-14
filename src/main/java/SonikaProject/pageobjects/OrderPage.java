package SonikaProject.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SonikaProject.AbstractComponent.AbstractComponent;


public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr//td[2]")
	List<WebElement> orderLists;
	
	@FindBy(css=".text-validated:nth-child(1)")
	WebElement countrySele;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public Boolean orderOfList(String productName)
	{
		orderButton();
		Boolean prodOrder=orderLists.stream().anyMatch(iCart->iCart.getText().equalsIgnoreCase(productName));
		return prodOrder;
		
		
	}

}
