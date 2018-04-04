import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseLogin {
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
		
		
		//opens newegg
		modules.OpenNewEgg(driver);
		
		//clicks on login link
		driver.findElement(By.partialLinkText("Log in or Register")).click();
		
		modules.login(driver, "npgomes@uncg.edu", "Germany95!@");
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
			
		}
	
	}
	

