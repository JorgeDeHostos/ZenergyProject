import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseOrderHistoryGuest {
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
		
		//open NewEgg
		modules.OpenNewEgg(driver);
		
		
		//click track order	
		modules.ClickTrackOrder(driver);
		
		//order number information
		modules.OrderNumberInformation(driver,"413892633", "27502");
		
		
		
		//clicks finds history
		modules.ClickFindHistory(driver);
		
		
		
		Thread.sleep(4000);
		driver.quit();
		
		modules.TestCasePassed();
		
}

}
