import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseOrderHistoryGuest {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseOrderHistoryGuest.txt");
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
		
		//open NewEgg
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
		
		
		//click track order	
		HomePage.ClickTrackOrder(driver, printWriter, timestamp);
		
		
		
		//order number information
		GuestCustomersPage.OrderNumberInformation(driver,"413892633", "27502", printWriter, timestamp);
		
		
		
		//clicks finds history
		GuestCustomerOrderViewPage.ClickFindHistory(driver, printWriter, timestamp);
		
		
		
		Thread.sleep(4000);
		driver.quit();
		
		//Test case passed
		modules.TestCasePassed(printWriter, timestamp);
		printWriter.close();
}

}
