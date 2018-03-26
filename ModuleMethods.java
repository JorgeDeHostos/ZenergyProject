package testcases;
import java.awt.Desktop.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModuleMethods {
	public static WebDriver driver;
	//to change chromedriver file address on multiple computers
	public static String chromedriverFileAddress = "F:\\Classes\\ISM452\\Zenergy\\chromedriver_win32\\chromedriver.exe";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",chromedriverFileAddress);
		driver = new ChromeDriver();
	}
	public void openNewEgg() {
		//open NewEgg homepage 
		driver.get("http://www.newegg.com");	
	}

	public void search() {	
		// Instantiate a composite action builder
		Actions builder = new Actions(driver);
		// Use the builder to create a composite action
		org.openqa.selenium.interactions.Action clickAndInput = builder.sendKeys("AMD RX 580", Keys.ENTER)
		.build();
				
		By search = By.id("haQuickSearchBox");
		driver.findElement(search).click();
		// Perform the composite action
		clickAndInput.perform();
		
		/*why not use following search? >> Chrome has a know issue that couldn't focus. Action builder helped to focus.
		//driver.findElement(search).sendKeys("AMD RX 580");
		//Search.sendKeys("AMD RX 580");
		//driver.findElement(search).submit(); //Click Search	>>Search Results display*/
	}
	
}
