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
		Search.sendKeys("ASUS ROG Strix Radeon RX 580 O8G Gaming OC Edition GDDR5 DP HDMI DVI VR Ready AMD Graphics Card with RGB Lighting (ROG-STRIX-RX580-O8G-GAMING)");
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
		
		//adds the warranty
		driver.findElement(By.id("CHECK_SNET-66000601")).click();
		
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
		driver.findElement(By.partialLinkText("$449.99 (1 Items)")).click();
		
		
		
		

		
		
		

		
		
}
	}
