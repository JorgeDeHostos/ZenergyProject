import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostProductPage {
	//clicks on the view item link
	public static void ClickViewItem( WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		//view shopping cart
		driver.findElement(By.partialLinkText("Items")).click();
		printWriter.println(timestamp + " Clicks view item ");
		System.out.println(timestamp + " Clicks view item");
	}
	

}
