import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseAddressBook {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseAddress.txt");
		PrintWriter printWriter = new PrintWriter(writer);
		
		
		
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
		
		try {
		//opens newegg.com
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
		js.executeScript("window.scrollBy(0,5000)");
		
		//clicks address book
		HomePage.ClickAddressBook(driver, printWriter, timestamp);
		
		
		//login information
		LoginPage.Login(driver, "npgomes@uncg.edu", "Germany95!@", printWriter, timestamp);
		
		//clicks add new address and inputs information
		AccountSettingsPage.InputNewAddressInformation(driver, printWriter, timestamp);
		
		//searches address book for other addresses
		AccountSettingsPage.findAddress(driver, "Old Address", printWriter, timestamp);
		driver.findElement(By.name("keyword")).clear();
		
		
		AccountSettingsPage.findAddress(driver, "Main Address", printWriter, timestamp);
		
		//clicks view edit to see address
		AccountSettingsPage.ClickViewEditAddress(driver, printWriter, timestamp);
		
	
		//clicks delete and yes
		AccountSettingsPage.ClickDeleteAddress(driver, printWriter, timestamp);
		
		Thread.sleep(5000);
		driver.quit();
		
		modules.TestCasePassed(printWriter, timestamp);
		printWriter.close();
		
		
		}catch (Exception e) {
			printWriter.println(timestamp + " The test has failed check the website for element changes");
			System.out.println(timestamp +" The test has failed check the website for element changes");
			printWriter.close();
			driver.quit();
		}
		
	
	}

}
