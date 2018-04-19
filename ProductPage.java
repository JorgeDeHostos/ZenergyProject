import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	//find add to cart id and clicks it
	public static void ClickAddToCart(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
				List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
				ClickAdd.get(0).click();
				Thread.sleep(2000);
				printWriter.println(timestamp + " Clicks Add to Cart");
				System.out.println(timestamp + " Clicks Add to Cart");
	}
	

}
