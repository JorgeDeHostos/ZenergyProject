import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountSettingsPage {
	
	//inputs address information
	public static void InputNewAddressInformation(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
		WebElement ClickAddNewAddress = driver.findElement(By.id("addAddrLink"));
		ClickAddNewAddress.click();
		
		WebElement FirstName = driver.findElement(By.name("SFirstName"));
		FirstName.sendKeys("Nelson");
		Thread.sleep(3000);
		
		WebElement MiddleName = driver.findElement(By.name("SMI"));
		MiddleName.sendKeys("Patrick");
		Thread.sleep(3000);
		
		WebElement LastName = driver.findElement(By.name("SLastName"));
		LastName.sendKeys("Gomes");
		Thread.sleep(3000);
		
		WebElement AddressLineOne = driver.findElement(By.name("SAddress1"));
		AddressLineOne.sendKeys("1609 Wright Avenue");
		Thread.sleep(3000);
		
		WebElement City = driver.findElement(By.name("SCity"));
		City.sendKeys("Greensboro");
		
		WebElement dropDownListBox = driver.findElement(By.name("SState"));
		Select dropList = new Select(dropDownListBox);
		dropList.selectByVisibleText("NORTH CAROLINA");
		Thread.sleep(3000);
		
		WebElement ZipCode = driver.findElement(By.name("SZip"));
		ZipCode.sendKeys("27403");
		Thread.sleep(3000);
		
		WebElement TelOne = driver.findElement(By.name("ShippingPhone_tel1"));
		TelOne.sendKeys("910");
		Thread.sleep(1000);
		
		WebElement TelTwo = driver.findElement(By.name("ShippingPhone_tel2"));
		TelTwo.sendKeys("920");
		Thread.sleep(1000);
		
		WebElement TelThree = driver.findElement(By.name("ShippingPhone_tel3"));
		TelThree.sendKeys("6063");
		Thread.sleep(1000);
		
		WebElement NameAddress = driver.findElement(By.name("SLabel"));
		NameAddress.sendKeys("Main Address");
		Thread.sleep(3000);
		
		List <WebElement> ClickSave = driver.findElements(By.cssSelector("a[href^='javascript']"));
		WebElement c = null;
	
			for (WebElement Click : ClickSave) {
				String List = Click.getText();
				if (List.contains("Save")) { 
					c = Click;
					
				}
			}
			c.click();
			
			printWriter.println(timestamp + " Inputs new registration info successfully");
			System.out.println(timestamp + " Inputs new registration info successfully");
			
	}
	
	
	//finds specific address
	public static void findAddress(WebDriver driver, String Name, PrintWriter printWriter, Timestamp timestamp) {
		WebElement FindAddress = driver.findElement(By.name("keyword"));
		FindAddress.sendKeys(Name);
		
		
		List<WebElement> ClickGo = driver.findElements(By.cssSelector("a[href^='javascript']"));
		WebElement C = null;
		for (WebElement Click : ClickGo) {
			String List = Click.getText();
			
			
			if(List.contains("Go")) {
				C = Click;	
			}
			
		}
		C.click();
		
		printWriter.println(timestamp +" find's the address successfully");
		System.out.println(timestamp +" find's the address successfully");
	}
	
	//clicks views and edits the address
	public static void ClickViewEditAddress(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		List <WebElement> ViewEdit = driver.findElements(By.cssSelector("a[href^='javascript']"));
		WebElement C = null;
		for(WebElement View : ViewEdit) {
			String List = View.getText();
			if(List.contains("edit")) {
				C = View;
				
			}
		}
		C.click();
		
		printWriter.println(timestamp + " Views and Edits address successfully ");
		System.out.println(timestamp + " Views and Edits address successfully");
	}
	
	
	//deletes the searched up address
		public static void ClickDeleteAddress(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
			List <WebElement> Delete = driver.findElements(By.cssSelector("a[href^='javascript'"));
			WebElement D = null;
			for (WebElement Del: Delete) {
				String List = Del.getText();
				
				if(List.contains("Delete")) {
					D = Del;
				}
			}
			D.click();
			Thread.sleep(3000);
			
		
			
			List <WebElement> Yes = driver.findElements(By.cssSelector("a[href^='javascript'"));
			WebElement Y = null;
			for (WebElement yes : Yes) {
				String List = yes.getText();
				
				if(List.contains("Yes")) {
					Y = yes;
				}
			}
			Y.click();
			printWriter.println(timestamp + " Deletes address successfully");
			System.out.println(timestamp + " Deletes address successfully");
				
				
		}
		
		//clicks account settings 
		public static void ClickAccountSettings(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
			WebElement Settings = driver.findElement(By.partialLinkText("Account Settings"));
			Settings.click();
			
			printWriter.println(timestamp + " Clicks on account settings");
			System.out.println(timestamp + " Clicks on account settings");
			
		}
		
		//clicks on edit password
		public static void ClickEditPassword(WebDriver driver,PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
			List <WebElement> ClickEditPassword = driver.findElements(By.xpath("//button[contains(.,'Edit')]"));
			ClickEditPassword.get(2).click();
			Thread.sleep(3000);
			System.out.println(timestamp + " Clicks on edit password");
			printWriter.println(timestamp + " Clicks on edit password");
		}
		
		
		//Fills in old password and new password
		public static void EditPassword(WebDriver driver, String OldPassword, String NewPassword, String ReEnterNewPassword, JavascriptExecutor js, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
			int ok_size=driver.findElements(By.name("Password")).size();
			List<WebElement> OriginalPass = driver.findElements(By.name("Password"));
			OriginalPass.get(ok_size-1).sendKeys(OldPassword);
			Thread.sleep(2000);
			
			
			WebElement NewPass = driver.findElement(By.name("newpassword"));
			NewPass.sendKeys(NewPassword);
			Thread.sleep(2000);
			
			
			
			WebElement ReEnterNewPass = driver.findElement(By.name("newpassword1"));
			ReEnterNewPass.sendKeys(ReEnterNewPassword);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,300)");
			WebElement ClickSaveChanges = driver.findElement(By.id("submitPassword"));
			ClickSaveChanges.click();
			printWriter.println(timestamp + " Edit's the password");
			System.out.println(timestamp + " Edit's the password");
		}

		//selects order time frame
		public static void SelectOrderTimeFrame(WebDriver driver, JavascriptExecutor js, PrintWriter printWriter, Timestamp timestamp) {
			WebElement dropDownListBox = driver.findElement(By.name("selectOrderTimeRegion"));
			Select dropList = new Select(dropDownListBox);
			dropList.selectByVisibleText("All");
			dropDownListBox.submit();
			js.executeScript("window.scrollBy(0,300)");
			
			printWriter.println(timestamp + " Selects order time frame");
			System.out.println(timestamp + " Selects order time frame");
			
		}

}
