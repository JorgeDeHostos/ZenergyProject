import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingInfoPage {
	// inputs information for an actual account
	public static void ShippingAddress(WebDriver driver, JavascriptExecutor js, String FName, String LName, String AddressLine1, String EnterCity, String DropStateList, String EnterZip, String PhoneNumber, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException{
		//clicks radio button
		WebElement Radio = driver.findElement(By.id("shippingAddressAdd"));
		Radio.click();
		Thread.sleep(3000);
		
		//inputs first name
		WebElement FirstName = driver.findElement(By.id("SFirstName"));
		FirstName.click();
		FirstName.sendKeys(FName);
		
		//inputs last name
		WebElement LastName = driver.findElement(By.id("SLastName"));
		LastName.click();
		LastName.sendKeys(LName);
		
		//inputs address on line one
		WebElement AddressLineOne = driver.findElement(By.id("SAddress1"));
		AddressLineOne.click();
		AddressLineOne.sendKeys(AddressLine1);
		
		//inputs city
		WebElement City = driver.findElement(By.id("SCity"));
		City.click();
		City.sendKeys(EnterCity);
		Thread.sleep(2000);
		
		//selects dropbox menu and picks a state
		WebElement dropDownListBox = driver.findElement(By.id("SState_Option_USA"));
		Select dropList = new Select(dropDownListBox);
		dropList.selectByVisibleText(DropStateList);
		Thread.sleep(2000);
		
		//inpts zipcode
		WebElement ZipCode = driver.findElement(By.id("SZip"));
		ZipCode.click();
		ZipCode.sendKeys(EnterZip);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,2000)");

		
		//inputs phone number
		WebElement Phone = driver.findElement(By.name("ShippingPhone"));
		Phone.click();
		Phone.sendKeys(PhoneNumber);
		
		
		
		//unselect box
		WebElement Unselect = driver.findElement(By.id("saveShipping"));
		Unselect.click();
		
		printWriter.println(timestamp + " Fills in shipping information successfully");
		System.out.println(timestamp + " Fills in shipping information successfully");
	}
	//clicks continue billing
	public static void ClickContinueBilling(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		
		List <WebElement> Billing = driver.findElements(By.cssSelector("a[href^='javascript']"));	
		WebElement C = null;
		for(WebElement Continue : Billing) {
			String List = Continue.getText();
			
			if(List.contains("CONTINUE")) {
				C = Continue;
			}
		}
		C.click();
		
		printWriter.println(timestamp + " Clicks Continue Billing");
		System.out.println(timestamp + " Clicks Continue Billing");
	}
	//inputs information for guest account
		public static void GuestAddress(WebDriver driver, JavascriptExecutor js,  String FName, String LName, String AddressLine1, String EnterCity, String DropStateList, String EnterZip, String PhoneNumber, String UnregisteredEmail, PrintWriter printWriter, Timestamp timestamp ) throws InterruptedException {
			
			
			//inputs first name
			WebElement FirstName = driver.findElement(By.name("SFirstName"));
			FirstName.clear();
			FirstName.sendKeys(FName);
			
			//inputs last name
			WebElement LastName = driver.findElement(By.name("SLastName"));
			LastName.click();
			LastName.sendKeys(LName);
			
			
			//inputs text to address line one
			WebElement AddressLineOne = driver.findElement(By.name("SAddress1"));
			AddressLineOne.click();
			AddressLineOne.sendKeys(AddressLine1);
			
			//inputs City
			WebElement City = driver.findElement(By.name("SCity"));
			City.click();
			City.sendKeys(EnterCity);
			
			//inputs STATE on dropdown box
			WebElement dropDownListBox = driver.findElement(By.id("SState_Option_USA"));
			Select dropList = new Select(dropDownListBox);
			dropList.selectByVisibleText(DropStateList);
			Thread.sleep(2000);
			
			//inputs zipcode
			WebElement ZipCode = driver.findElement(By.name("SZip"));
			ZipCode.click();
			ZipCode.sendKeys(EnterZip);
			Thread.sleep(2000);
			
			//inputs phone number
			WebElement Phone = driver.findElement(By.name("ShippingPhone"));
			Phone.click();
			Phone.sendKeys(PhoneNumber);
			Thread.sleep(4000);
			
			js.executeScript("window.scrollBy(0,2000)");
			
			
			
			//inputs email
		
			int ok_size=driver.findElements(By.name("GuestEmail")).size();
			List<WebElement> Email = driver.findElements(By.name("GuestEmail"));
			Email.get(ok_size-1).sendKeys(UnregisteredEmail);
			
			printWriter.println(timestamp + " Fills in Shipping Information");
			System.out.println(timestamp + " Fills in Shipping Information");
			
			
		}
		

}
