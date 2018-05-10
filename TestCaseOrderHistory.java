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

public class TestCaseOrderHistory {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseOrderHistory.txt");
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
		//open NewEgg
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
		
		//click track order	
		HomePage.ClickTrackOrder(driver, printWriter, timestamp);
		
		
		//login information
		LoginPage.Login(driver, "jmdehost@uncg.edu", "Jdh005546!", printWriter, timestamp);
		
		
		//selects drop down box and clicks all
		AccountSettingsPage.SelectOrderTimeFrame(driver, js, printWriter, timestamp);
		
		Thread.sleep(4000);
		driver.quit();
		
		modules.TestCasePassed(printWriter, timestamp);
		printWriter.close();
		}catch(Exception e) {
			printWriter.println(timestamp + " The test has failed check your website for element changes");
			System.out.println(timestamp +" The test has failed check your website for element changes");
			printWriter.close();
			driver.quit();
		}
		
}
}
