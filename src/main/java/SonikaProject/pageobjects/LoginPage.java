package SonikaProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SonikaProject.AbstractComponent.AbstractComponent;


public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	/*WebElement userEmail= driver.findElement(By.id("userEmail"));
	userEmail.sendKeys("pundir@gmail.com");*/
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".toast-container")
	WebElement errorMsg;
	
	
	public ProductCataloguePage loginApp(String email, String password )
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCataloguePage productCataloguePage=new ProductCataloguePage(driver);
		return productCataloguePage;

	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String loginErrorMessage()
	{
		waitElementVisible(errorMsg);
		String errormsg=errorMsg.getText();
		return errormsg;
		
	}

}
