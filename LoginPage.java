import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//inputs login information 
	public static void Login(WebDriver driver, String User, String Pass, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
		//login information
				WebElement Username = driver.findElement(By.id("UserName"));
				Username.sendKeys(User);
				Thread.sleep(3000);
				WebElement Password = driver.findElement(By.id("UserPwd"));
				Password.sendKeys(Pass);
				
				WebElement Submit = driver.findElement(By.id("submitLogin"));
				Submit.click();
				
				printWriter.println(timestamp + " Logs in successfully");
				System.out.println(timestamp + " Logs in successfully");
	}

	//clicks on sign up for registration
	public static void ClickSignUpLink(WebDriver driver) {
		WebElement SignUp = driver.findElement(By.partialLinkText("Sign up"));
		SignUp.click();
		
	}
	

}
