import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseAddressBook {
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
		
		//opens newegg.com
		modules.OpenNewEgg(driver);
		
		//clicks address book
		WebElement ClickAddressBook = driver.findElement(By.partialLinkText("Address Book"));
		ClickAddressBook.click();
		
		//login information
		modules.Login(driver, "npgomes@uncg.edu", "Germany95!@");
		
		//clicks add new address and inputs information
		modules.InputNewAddressInformation(driver);
		
		//searches address book for other addresses
		modules.findAddress(driver);
		
		
		Thread.sleep(5000);
		
		driver.quit();
		
		modules.TestCasePassed();
		
		
	
	}

}
