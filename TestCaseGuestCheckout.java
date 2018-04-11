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
		modules.ProductSearch(driver, "Full Tower");
		
		
		//clicks on the first item on the list and list items on the webpage
		modules.ClickOnItem(driver,3);
		
		
		//find add to cart id and clicks it
		modules.ClickAddToCart(driver);
		
		//view shopping cart
		modules.ClickViewItem(driver);
	
		// Clicks Secure Checkout 
		modules.ClickSecureCheckout(driver);
		
		// Clicks Guest Checkout
		modules.ClickGuestCheckout(driver);
	
		
		//fills in shipping address information
		String FName= "Nelson";
		String LName = "Gomes";
		String AddressLine1 = "1609 Wright Avenue";
		String EnterCity = "Greensboro";
		
		//Make sure you enter all caps for DropStateList to select specific state
		String DropStateList = "NORTH CAROLINA";
		String EnterZip = "27403";
		String PhoneNumber = "9109206063";
		String UnregisteredEmail = "nelgomes1@hotmail.com";
		
		modules.GuestAddress(driver, js, wait, FName, LName, AddressLine1, EnterCity, DropStateList, EnterZip, PhoneNumber, UnregisteredEmail);
		
		//Clicks Continue Billing
		modules.ClickContinueBilling(driver);
		
		Thread.sleep(5000);
		
		driver.quit();
		
		// if all of the modules work it should display message that says the test has passed
		modules.TestCasePassed();
		
		
}
}
