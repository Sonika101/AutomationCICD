package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SonikaProject.TestComponent.Retry;

import SonikaProject.TestComponent.BaseTest;
import SonikaProject.pageobjects.Cartpage;
import SonikaProject.pageobjects.CheckoutPage;
import SonikaProject.pageobjects.ConfirmationPage;
import SonikaProject.pageobjects.LoginPage;
import SonikaProject.pageobjects.ProductCataloguePage;

public class LoginErrorValidationTest extends BaseTest {
	
	@Test(groups={"Smoke"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

		String email="pundir@gmail.com";
		String password="Sonika@103";

		ProductCataloguePage productCataloguePage=loginPage.loginApp(email, password);
		String errorMsg=loginPage.loginErrorMessage();
		Assert.assertEquals(errorMsg, "Incorrect email or password.");
	}
	@Test
	public void ProductMatchValidation() throws IOException, InterruptedException
	{	
		String productName="ADIDAS ORIGINAL";
		String email="karanRawat@gmail.com";
		String password="Karan@101";
		
		ProductCataloguePage productCataloguePage=loginPage.loginApp(email, password);
		List<WebElement> allproducts=productCataloguePage.getProductList();
		Cartpage cartpage=productCataloguePage.addToCart(productName);
		Boolean itemCart=cartpage.itemsInCart(productName);
		Assert.assertTrue(itemCart);
	}

}
