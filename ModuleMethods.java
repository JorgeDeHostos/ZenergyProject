package testcases;
import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModuleMethods {
	public static WebDriver driver;
	//to change chromedriver file address on multiple computers
	public static String chromedriverFileAddress = "\\chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",chromedriverFileAddress);
		driver = new ChromeDriver();
		//implements google chrome
		//WebDriver driver = new ChromeDriver();
		
		/*String os = System.getProperty("os.name").toLowerCase();
		//implements google chrome
				WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//if its mac or windows
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		} */
		
			}

	
	
	public void openNewEgg() throws InterruptedException {
		//open NewEgg homepage 
		driver.get("http://www.newegg.com");	
	}
	
	public void search() throws InterruptedException {	
		// Instantiate a composite action builder
		Actions builder = new Actions(driver);
		// Use the builder to create a composite action
		org.openqa.selenium.interactions.Action clickAndInput = builder.sendKeys("AMD RX 580", Keys.ENTER)
		.build();
				
		By search = By.id("haQuickSearchBox");
		driver.findElement(search).click();
		// Perform the composite action
		clickAndInput.perform();
		
		/*why not use following search? >> Chrome has a know issue that couldn't focus. Action builder helped to focus.
		//driver.findElement(search).sendKeys("AMD RX 580");
		//Search.sendKeys("AMD RX 580");
		//driver.findElement(search).submit(); //Click Search	>>Search Results display*/
	}
	
	public void selectItem() throws InterruptedException {
	//clicks on the first item on the list
			List<WebElement> Products = driver.findElements(By.className("item-title"));
			System.out.println("This is list of items:");
			
			for(WebElement ProductList : Products) {
				String List = ProductList.getText();
				System.out.println(List);
			}
	//clicks on the first product
			Products.get(0).click();
			Thread.sleep(2000);
	}
	
	public void addWarrenty() throws InterruptedException {
	//adds the warranty
			//driver.findElement(By.id("CHECK_SNET-66000600")).click();
		driver.findElement(By.cssSelector("li[class='primary']")).click();
	}
	
	public void addtoCart()throws InterruptedException {
	System.out.println("");
	//find add to cart tag and clicks it
	List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
	List<WebElement> ClickAdd = driver.findElements(By.cssSelector(".button.btn.btn-primary.btn-wide"));
	
	System.out.println("This is the list for add to cart");
	for (WebElement AddToCart : ClickAdd ) {
	String List = AddToCart.getText();
		System.out.println(List);
	}
	ClickAdd.get(0).click();
	Thread.sleep(2000);
	((WebElement) driver.findElements(By.cssSelector("button[class='btn btn-primary btn-wide']"))).click();
	}
	
	public void viewCartAfterAddtoCart() throws InterruptedException{
		//view shopping cart
		driver.findElement(By.partialLinkText("$449.99 (1 Items)")).click();
		//<button type="button" title="View Shopping Cart" class="btn btn-primary" 
		//driver.findElement(By.className("button.btn.btn-primary")).click();		
		//driver.findElement(By.cssSelector("button[title='View Shopping Cart' class='btn btn-primary']")).click();	
	}
	
	public void secureCheckout() throws InterruptedException{
	// Clicks Secure Checkout 
			List <WebElement> SecureCheckout = driver.findElements(By.cssSelector("a[href^='javascript']"));
			WebElement Secure = null;
		
				for (WebElement SecureCheck : SecureCheckout) {
					String List = SecureCheck.getText();
					
					System.out.println(List);
					
					if (List.contains("SECURE")) { 
						Secure = SecureCheck;
						System.out.println("Passed");
					}
				}
			Secure.click();
			
			Thread.sleep(3000);
}
	
	public void login() throws InterruptedException{
		WebElement Login = driver.findElement(By.id("UserName"));
		Login.sendKeys("*******");
		Thread.sleep(3000);
		
		WebElement Password = driver.findElement(By.id("UserPwd"));
		Password.sendKeys("*******");
		
		WebElement Submit = driver.findElement(By.id("submit"));
		Submit.click();}
	}

