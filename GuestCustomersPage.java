import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestCustomersPage {
	//clicks guest checkout
		public static void ClickGuestCheckout(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
			
			WebElement Click = driver.findElement(By.xpath("//button[contains(.,'Continue as a Guest')]"));
			Click.click();
			
			printWriter.println(timestamp + " Clicks on Guest Checkout");
			System.out.println(timestamp + " Clicks on Guest Checkout");
		}
		//inputs order number information for guests or without login
		public static void OrderNumberInformation(WebDriver driver, String OrderNumber, String ZipCodeOREmail, PrintWriter printWriter, Timestamp timestamp) {
			int ok_size=driver.findElements(By.name("GuestOrderNumber")).size();
			List<WebElement> Order = driver.findElements(By.name("GuestOrderNumber"));
			Order.get(ok_size-1).sendKeys(OrderNumber);
			
			WebElement ZipOrEmail = driver.findElement(By.name("GuestEmailZipCode"));
			ZipOrEmail.sendKeys(ZipCodeOREmail);
			printWriter.println(timestamp + " Fills in Order information");
			System.out.println(timestamp + " Fills in Order information");
		
		}

}
