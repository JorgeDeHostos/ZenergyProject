
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseCheckout {
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
		
		//goes to newegg.com
		modules.OpenNewEgg(driver);
		
		//product search
		modules.ProductSearch(driver,"Tower");
		
		
		//clicks on the first item on the list and list items on the webpage
		modules.ClickOnItem(driver, 1);
		
		
		//find add to cart id and clicks it
		modules.ClickAddToCart(driver);
		
		//view shopping cart
		modules.ClickViewItem(driver);
	
		// Clicks Secure Checkout 
		modules.ClickSecureCheckout(driver);
		
		// login modules
		modules.login(driver,"npgomes@uncg.edu","Germany95!@");
		
		//enters shipping credentials
		String FName = "****";
		String LName = "******";
		String AddressLine1 = "*******";
		String EnterCity = "******";
		String DropStateList = "*******";
		String EnterZip = "********";
		String PhoneNumber= "********";
		
		
		
		
		modules.ShippingAddress(driver, js, FName, LName, AddressLine1, EnterCity, DropStateList, EnterZip, PhoneNumber);
	
		
		
		//clicks continue billing
		modules.ClickContinueBilling(driver);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	
		
		
}
	}
