import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



public class TestCaseRegister {
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
		
		//opens NewEgg
		modules.OpenNewEgg(driver);
		
		//Clicks on Log in and Register link
		modules.ClickLoginAndRegister(driver);
		
		//Clicks on create new account
		modules.ClickCreateNewAccount(driver);
		
		
		
		//inputs Registration information
		String email = "*********";
		String password = "********";
		modules.RegistrationInformation(driver, email, password);
		
		
		
		
		//Clicks create account
		modules.ClickCreateAccount(driver);
		
		//sleeps for 5 seconds before moving onto the next method
		Thread.sleep(5000);
		
		driver.quit();
		
		// if all of the modules work it should display message that says the test has passed
		modules.TestCasePassed();
		
		
		
}
	
}
