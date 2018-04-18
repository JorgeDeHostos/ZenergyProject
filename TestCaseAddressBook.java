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
		
		//opens newegg.com
		modules.OpenNewEgg(driver, printWriter, timestamp);
		
		//clicks address book
		modules.ClickAddressBook(driver, printWriter, timestamp);
		
		
		//login information
		modules.Login(driver, "npgomes@uncg.edu", "Germany95!@", printWriter, timestamp);
		
		//clicks add new address and inputs information
		modules.InputNewAddressInformation(driver, printWriter, timestamp);
		
		//searches address book for other addresses
		modules.findAddress(driver, "Old Address", printWriter, timestamp);
		
		
		driver.findElement(By.name("keyword")).clear();
		
		
		modules.findAddress(driver, "Main Address", printWriter, timestamp);
		
		//clicks view edit to see address
		modules.ViewEditAddress(driver, printWriter, timestamp);
		
	
		//clicks delete and yes
		modules.ClickDeleteAddress(driver, printWriter, timestamp);
		
		Thread.sleep(5000);
		driver.quit();
		
		modules.TestCasePassed(printWriter, timestamp);
		printWriter.close();
		
	
	}

}
