package SonikaProject.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SonikaProject.pageobjects.Cartpage;
import SonikaProject.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[text()='  ORDERS']")
	WebElement ordrBtn;
	
	

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void elementToBeVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitElementVisible(WebElement WebElement)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(WebElement));
	}

	public void elementToDisappear(By findBy) throws InterruptedException {

		Thread.sleep(2000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		 */
		 
	}

	public Cartpage cartButton() {
		cart.click();
		Cartpage cartpage=new Cartpage(driver);
		return cartpage;
	}
	
	public OrderPage orderButton()
	{
		ordrBtn.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}

}
