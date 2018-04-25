
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseLogin {
	

	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseLogin.txt");
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

		try {
		//opens newegg
		HomePage.OpenNewEgg(driver, printWriter, timestamp);
	
		
		
		//clicks on login link
		HomePage.ClickLoginAndRegister(driver, printWriter, timestamp);
		
		LoginPage.Login(driver, "npgomes@uncg.edu", "Germany95!@", printWriter, timestamp);
		
		
		
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
	
	

