package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SonikaProject.pageobjects.LoginPage;

public class standAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Githib and jenkins to trigeer through webhook
//One more try
//final try
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		String productName="ZARA COAT 3";
		
		LoginPage loginPage=new LoginPage(driver);
		
		WebElement userEmail= driver.findElement(By.id("userEmail"));
		userEmail.sendKeys("pundir@gmail.com");
		
		WebElement userPassword= driver.findElement(By.id("userPassword"));
		userPassword.sendKeys("Sonika@101");
		
		WebElement login=driver.findElement(By.id("login"));
		login.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		List<WebElement> allproducts=driver.findElements(By.cssSelector(".mb-3"));
		//wait.until(ExpectedConditions.visibilityOfAllElements(allproducts));
		
		WebElement prod=allproducts.stream().filter(allproduct-> 
		allproduct.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		/*WebElement prod =	allproducts.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);*/
		
		WebElement toast_container=driver.findElement(By.id("toast-container"));
		wait.until(ExpectedConditions.invisibilityOf(toast_container));
		
		
		WebElement cart=driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
		cart.click();
		List<WebElement> itemCarts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean itemCart=itemCarts.stream().anyMatch(iCart->iCart.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(itemCart);
		
		//button[text()='Checkout']
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		
		WebElement countrySele=driver.findElement(By.cssSelector(".text-validated:nth-child(1)"));
		
		countrySele.sendKeys("Ind");
		
		List<WebElement> countries=driver.findElements(By.cssSelector(".list-group-item"));
		WebElement country=countries.stream().filter(countrys->countrys.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		country.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String message=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		
		driver.close();
		
		
		
		
		
		
		
		
		
		

	}

}
