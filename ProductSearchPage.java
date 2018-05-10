import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearchPage {
	
	
	//clicks on the product based on the order of the products displayed
		public static void ClickOnItem(WebDriver driver, int ItemNumberOnList, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
			//clicks on the the item on the list and list items on the webpage
			List<WebElement> Products = driver.findElements(By.className("item-title"));
			Products.get(ItemNumberOnList-1).click();
			Thread.sleep(2000);
			printWriter.println(timestamp + " Clicks on item");
			System.out.println(timestamp + " Clicks on item");
		}
		
		
		//lists products on the page
		public static void ListItemOnProductSearch(WebDriver driver, PrintWriter printWriter) {
			List<WebElement> Products = driver.findElements(By.className("item-title"));
			System.out.println("This is the list of items:");
			printWriter.println("\nThis is the list of items: "); 
			for(WebElement ProductList : Products) {
				String List = ProductList.getText();
				System.out.println(List);
				printWriter.println(List);
				
				
			}
}
}