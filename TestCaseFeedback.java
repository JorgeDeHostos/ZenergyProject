import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseFeedback {
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
		
		//clicks feedback link
		WebElement Feedback = driver.findElement(By.partialLinkText("Feedback"));
		Feedback.click();
		
		WebElement Click = driver.findElement(By.xpath("//button[contains(.,'Continue as a Guest')]"));
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	
	}

}
