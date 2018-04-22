import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	
	//opens the website new egg
	public static void OpenNewEgg(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		driver.get("https://www.newegg.com");
		printWriter.println(timestamp + " Opens new egg");
		System.out.println(timestamp + " Opens new egg");
		driver.manage().window().maximize();
		
	}
	
	//clicks on address book
	public static void ClickAddressBook(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		WebElement ClickAddressBook = driver.findElement(By.partialLinkText("Address Book"));
		ClickAddressBook.click();
		printWriter.println(timestamp + " Clicks on address book");
		System.out.println(timestamp + " Clicks on address book");
		
		
	}
	
	//clicks on log in and register link on the top
	public static void ClickLoginAndRegister(WebDriver driver,  PrintWriter printWriter,Timestamp timestamp) {
		driver.findElement(By.partialLinkText("Log in or Register")).click();
		printWriter.println(timestamp + " Clicks on log in and register link");
		System.out.println(timestamp + " Clicks on log in and register link");
	}
	//clicks My Dashboard on the homepage
	
		public static void ClickMyDashboard(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
			WebElement Dashboard = driver.findElement(By.partialLinkText("My Dashboard"));
			Dashboard.click();
			
			printWriter.println(timestamp + " Clicks on dashboard on the homepage");
			System.out.println(timestamp + " Clicks on dashboard on the homepage");
		}
		
		
		//searches for specific product
		public static void ProductSearch(WebDriver driver, String Product, PrintWriter printWriter, Timestamp timestamp) {
		
			WebElement Search = driver.findElement(By.id("haQuickSearchBox"));
			
			Search.click();
			Search.sendKeys(Product);
			Search.submit();
			
			printWriter.println(timestamp + " Searches product");
			System.out.println(timestamp + " Searches product");
		}
		
		//clicks on 72 deals link on the homepage
		public static void ClickOnSeventyTwoDeals(WebDriver driver, JavascriptExecutor js, PrintWriter printWriter, Timestamp timestamp ) throws InterruptedException {
			List <WebElement> SeventyTwoDeals = driver.findElements(By.cssSelector("a[href^='//www.newegg.com/DailyDeal.aspx?name=DailyDeal&cm_sp=Dailydeal-_-adlink-_-04222018"));
			SeventyTwoDeals.get(0).click();
			Thread.sleep(3000);
			printWriter.println(timestamp + " Clicks on Seventy two deals on homepage");
			System.out.println(timestamp + " Clicks on Seventy two deals on homepage");
			
		}
		//clicks on track order on the webpage
		public static void ClickTrackOrder(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
			WebElement TrackOrder = driver.findElement(By.id("trackOrder"));
			TrackOrder.click();
			printWriter.println(timestamp + " Clicks on Track Order on Homepage");
			System.out.println(timestamp + " Clicks on Track Order on Homepage");
		}
	
	
	
	
	
}
