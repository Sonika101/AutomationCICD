package SonikaProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SonikaProject.AbstractComponent.AbstractComponent;


public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".list-group-item")
	List<WebElement> countries;
	
	@FindBy(css=".text-validated:nth-child(1)")
	WebElement countrySele;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public void checkoutDetails(String countryname)
	{
		countrySele.sendKeys(countryname);
		WebElement country=countries.stream().filter(countrys->countrys.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		country.click();
	}
	
	public ConfirmationPage goToConfirmationpage()
	{
		placeOrder.click();
		ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		return confirmationpage;
	}
	

}
