import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseProductSearch {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseProductSearch.txt");
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
		//opens newegg
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
		
		//searches string that you want to search
		HomePage.ProductSearch(driver, "Tower", printWriter, timestamp);
		
		//checks valid title of the page and product matches
		modules.CheckTitleOnPage(driver, "Tower - Newegg.com");
		
		System.out.println("");


		
		
		
		//list the items on the webpage
		ProductSearchPage.ListItemOnProductSearch(driver,printWriter);
		
		//clicks on item list that you want to click on I decide to pick the 3rd item on the list
		ProductSearchPage.ClickOnItem(driver, 1, printWriter, timestamp);
		
		Thread.sleep(5000);
		
		driver.quit();
		
		// if all of the modules work it should display message that says the test has passed
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
