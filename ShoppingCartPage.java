import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	// Clicks Secure Checkout 
		public static void ClickSecureCheckout(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
		
			List <WebElement> SecureCheckout = driver.findElements(By.cssSelector("a[href^='javascript']"));
			WebElement Secure = null;
		
				for (WebElement SecureCheck : SecureCheckout) {
					String List = SecureCheck.getText();
					
					if (List.contains("SECURE")) { 
						Secure = SecureCheck;
						
					}
				}
			Secure.click();
			
			Thread.sleep(3000);
			printWriter.println(timestamp + " Clicks Secure Checkout");
			System.out.println(timestamp + " Clicks Secure Checkout");
		}

}
