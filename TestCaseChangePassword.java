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

public class TestCaseChangePassword {
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		File writer = new File("LogTestCaseChangePassword.txt");
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
	
	
	//opens NewEgg
	modules.OpenNewEgg(driver, printWriter, timestamp);

	//clicks log in and register on homepage
	modules.ClickLoginAndRegister(driver, printWriter, timestamp);
	
	modules.Login(driver, "npgomes@uncg.edu", "Germany95!@", printWriter, timestamp);
	Thread.sleep(2000);
	
	
	//clicks on my dashboard on homepage
	modules.ClickMyDashboard(driver, printWriter, timestamp);
	
	
	//clicks on account settings
	modules.ClickAccountSettings(driver, printWriter, timestamp);
	
	
	//clicks on edit password on account settings
	modules.ClickEditPassword(driver, printWriter, timestamp);
	

	
	//fills in old password and new password	
	String OldPassword = "Germany95!@";
	String NewPassword = "Germany95!@";
	String ReEnterNewPassword = "Germany95!@";
	
	
	modules.EditPassword(driver, OldPassword, NewPassword, ReEnterNewPassword, js, printWriter, timestamp);
	
	
	
	
	Thread.sleep(5000);
	
	driver.quit();
	
	modules.TestCasePassed(printWriter, timestamp);
	printWriter.close();
	
}



}
