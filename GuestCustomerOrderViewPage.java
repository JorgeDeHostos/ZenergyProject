import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestCustomerOrderViewPage {
	//clicks find history
		public static void ClickFindHistory(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
			WebElement Click = driver.findElement(By.xpath("//button[contains(.,'Find My Order ')]"));
			Click.click();
			printWriter.println(timestamp + " Clicks Find History");
			System.out.println(timestamp + " Clicks Find History");
		}
		

}
