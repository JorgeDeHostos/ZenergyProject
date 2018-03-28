import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseProductSearch {
	public static void main(String[] args) throws InterruptedException {
		String os = System.getProperty("os.name").toLowerCase();
		//implements google chrome
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//if its mac or windows
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		
		//goes to newegg.com
		driver.get("https://www.newegg.com");
		
		
		
		WebElement Search = driver.findElement(By.id("haQuickSearchBox"));
		
		Search.click();
		Search.sendKeys("AMD RX500");
		Search.submit();
		
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
		
		//adds the warranty and its optional depending on the product just uncomment and change ID element
		//driver.findElement(By.id("CHECK_SNET-66000601")).click();
		
		System.out.println("");
		//find add to cart tag and clicks it
		List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
		
		System.out.println("This is the list for add to cart");
		for (WebElement AddToCart : ClickAdd ) {
		String List = AddToCart.getText();
			System.out.println(List);
		}
		ClickAdd.get(0).click();
		Thread.sleep(2000);
		
		
		//view shopping cart
		driver.findElement(By.partialLinkText("(1 Items)")).click();
	
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
		
		//login use modules here
		WebElement Login = driver.findElement(By.id("UserName"));
		Login.sendKeys("npgomes@uncg.edu");
		Thread.sleep(3000);
		
		WebElement Password = driver.findElement(By.id("UserPwd"));
		Password.sendKeys("Germany95!@");
		
		WebElement Submit = driver.findElement(By.id("submit"));
		Submit.click();
		
		

		
		
}
	}
