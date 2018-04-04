import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseGuestCheckout {
	public static void main(String[] args) throws InterruptedException {
		String os = System.getProperty("os.name").toLowerCase();
		//implements google chrome
		
		
		//if its mac or windows
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//goes to newegg.com
		modules.OpenNewEgg(driver);
		
		//product search
		modules.ProductSearch(driver, "Tower");
		
		
		//clicks on the first item on the list and list items on the webpage
		modules.ClickOnItem(driver,1);
		
		
		//find add to cart id and clicks it
		modules.ClickAddToCart(driver);
		
		//view shopping cart
		modules.ClickViewItem(driver);
	
		// Clicks Secure Checkout 
		modules.ClickSecureCheckout(driver);
		
		// Clicks Guest Checkout
		modules.ClickGuestCheckout(driver);
		
		
		//fills in shipping address information
		String FName= "******";
		String LName = "*******";
		String AddressLine1 = "*******";
		String EnterCity = "*********";
		
		//Make sure you enter all caps for DropStateList to select specific state
		String DropStateList = "******";
		String EnterZip = "********";
		String PhoneNumber = "*********";
		
		modules.GuestAddress(driver, js, wait, FName, LName, AddressLine1, EnterCity, DropStateList, EnterZip, PhoneNumber);
		
		//Clicks Continue Billing
		modules.ClickContinueBilling(driver);
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
}
}
