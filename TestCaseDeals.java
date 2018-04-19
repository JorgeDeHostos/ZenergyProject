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

public class TestCaseDeals {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseDeals.txt");
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
		
		//goes to newegg.com
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
		js.executeScript("window.scrollBy(0,1000)");
		
		
		//clicks on 72 deals link
		HomePage.ClickOnSeventyTwoDeals(driver, js, printWriter, timestamp);
		
		//checks the title of the page
		modules.CheckTitleOnPage(driver, "Daily Deals - Newegg.com");
		
		
		//selects each dropdown for in stock, lowest price, highest price, best rating, most reviews
		SeventyTwoDealsPage.dropDownDeals(driver, js, printWriter, timestamp);
		
		driver.quit();
		
		modules.TestCasePassed(printWriter, timestamp);
		printWriter.close();
}
}