import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseDeals {
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
		
		
		//clicks on 72 deals link
		modules.ClickOnSeventyTwoDeals(driver, js);
		
		//checks the title of the page
		modules.CheckTitleOnPage(driver, "Daily Deals - Newegg.com");
		
		
		//selects each dropdown for in stock, lowest price, highest price, best rating, most reviews
		modules.dropDownDeals(driver, js);
		
		driver.quit();
		
		modules.TestCasePassed();
}
}