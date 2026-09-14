package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SonikaProject.TestComponent.BaseTest;
import SonikaProject.pageobjects.Cartpage;
import SonikaProject.pageobjects.CheckoutPage;
import SonikaProject.pageobjects.ConfirmationPage;
import SonikaProject.pageobjects.LoginPage;
import SonikaProject.pageobjects.OrderPage;
import SonikaProject.pageobjects.ProductCataloguePage;

public class SubmitOrderTest extends BaseTest {
	
	@Test(dataProvider="getData", groups="Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		
		ProductCataloguePage productCataloguePage=loginPage.loginApp(input.get("email"), input.get("password"));
		
		//ProductCataloguePage productCataloguePage=new ProductCataloguePage(driver);
		List<WebElement> allproducts=productCataloguePage.getProductList();
		Cartpage cartpage=productCataloguePage.addToCart(input.get("productName"));
		
		
		//Cartpage cartpage=new Cartpage(driver);
		Boolean itemCart=cartpage.itemsInCart(input.get("productName"));
		Assert.assertTrue(itemCart);
		cartpage.geToCheckoutPage();
		
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.checkoutDetails(countryname);
		ConfirmationPage confirmationpage=checkoutpage.goToConfirmationpage();
		
		//ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		String message=confirmationpage.confirmMessage();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");

	}
	@Test(dependsOnMethods="submitOrder")
	public void oderHistory()
	{
		ProductCataloguePage productCataloguePage=loginPage.loginApp(email, password);
		OrderPage orderpage=new OrderPage(driver);
		Boolean match=orderpage.orderOfList(productName);
		Assert.assertTrue(match);	
	}
	
	/*
	@DataProvider(name="getData")
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"pundir@gmail.com", "Sonika@101", "ZARA COAT 3"},
			{"karanRawat@gmail.com", "Karan@101", "ADIDAS ORIGINAL"}
				};
	}
	*/
	
	/*@DataProvider(name="getData")
	public Object[][] getData()
	{
		HashMap<String, String> map=new HashMap<String, String>();
			map.put("email", "pundir@gmail.com");
			map.put("password", "Sonika@101");
			map.put("productName", "ZARA COAT 3");
			
			
		HashMap<String, String> map1=new HashMap<String, String>();
			map1.put("email", "karanRawat@gmail.com");
			map1.put("password", "Karan@101");
			map1.put("productName", "ADIDAS ORIGINAL");
			
			return new Object[][]
					{{map},{map1}};
				}
				*/
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//SonikaProject//Data//Purchase.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
		
	}

