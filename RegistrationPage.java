import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	//inputs registration info
	public static void InputRegistrationInfo(WebDriver driver, String FName, String LName, String InputEmail, String Pass, PrintWriter printWriter,Timestamp timestamp) throws InterruptedException {
		
		WebElement FirstName = driver.findElement(By.name("FirstName"));
		FirstName.sendKeys(FName);
		Thread.sleep(3000);
		
		WebElement LastName = driver.findElement(By.name("LastName"));
		LastName.sendKeys(LName);
		Thread.sleep(3000);
		
		WebElement Email = driver.findElement(By.name("LoginName"));
		Email.sendKeys(InputEmail);
		Thread.sleep(3000);
		
		WebElement Password = driver.findElement(By.name("Password"));
		Password.sendKeys(Pass);
		Thread.sleep(3000);
		
		WebElement Click = driver.findElement(By.id("submitRegistration"));
		Click.click();
		
		printWriter.println(timestamp + " Registration info has been filled properly");
		System.out.println(timestamp + " Registration info has been filled properly");
		
		
	}
}
