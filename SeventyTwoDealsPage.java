import java.io.PrintWriter;
import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeventyTwoDealsPage {
	
	//checks every dropdown
	public static void dropDownDeals(WebDriver driver, JavascriptExecutor js, PrintWriter printWriter, Timestamp timestamp ) throws InterruptedException {
		WebElement dropDownInStock = driver.findElement(By.id("Order_top"));
		Select inStock = new Select(dropDownInStock);
		inStock.selectByVisibleText("In Stock");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		
		WebElement dropDownLowestPrice = driver.findElement(By.id("Order_top"));
		Select LowestPrice = new Select(dropDownLowestPrice);
		LowestPrice.selectByVisibleText("Lowest Price");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		WebElement dropDownHighestPrice = driver.findElement(By.id("Order_top"));
		Select HighestPrice = new Select(dropDownHighestPrice);
		HighestPrice.selectByVisibleText("Highest Price");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		WebElement dropDownBestRating = driver.findElement(By.id("Order_top"));
		Select BestRating = new Select(dropDownBestRating);
		BestRating.selectByVisibleText("Best Rating");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		
		WebElement dropDownMostReview = driver.findElement(By.id("Order_top"));
		Select MostReview = new Select(dropDownMostReview);
		MostReview.selectByVisibleText("Most Reviews");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(5000);
		
		printWriter.println(timestamp + " Checks in stock, lowest price, highest price, best rating, and most reviews");
		System.out.println(timestamp + " Checks in stock, lowest price, highest price, best rating, and most reviews");
	
	}

}
