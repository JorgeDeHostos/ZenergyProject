import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseOrderHistory {
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
		
		//open NewEgg
		modules.OpenNewEgg(driver);
		
		
		//click track order	
		modules.ClickTrackOrder(driver);
		
		//login information
		modules.Login(driver, "jmdehost@uncg.edu", "Jdh005546!");
		
		//selects drop down box and clicks all
		modules.SelectOrderTimeFrame(driver, js);
		
		Thread.sleep(4000);
		driver.quit();
		
		modules.TestCasePassed();
		
}
}
