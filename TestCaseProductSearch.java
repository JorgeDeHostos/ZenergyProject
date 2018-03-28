import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseProductSearch {
	public static void main(String[] args) throws InterruptedException {
		String os = System.getProperty("os.name").toLowerCase();
		//implements google chrome
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//if its mac or windows
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		
		//goes to newegg.com
		driver.get("https://www.newegg.com");
		
		
		
		WebElement Search = driver.findElement(By.id("haQuickSearchBox"));
		
		Search.click();
		Search.sendKeys("AMD RX500");
		Search.submit();
		
		//clicks on the first item on the list
		List<WebElement> Products = driver.findElements(By.className("item-title"));
		System.out.println("This is list of items:");
		
		for(WebElement ProductList : Products) {
			String List = ProductList.getText();
			System.out.println(List);
		}
		Products.get(0).click();
		Thread.sleep(2000);
		
	
		
		
		//find add to cart tag and clicks it
		List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
		ClickAdd.get(0).click();
		Thread.sleep(2000);
		
		
		//view shopping cart
		driver.findElement(By.partialLinkText("(1 Items)")).click();
	
		// Clicks Secure Checkout 
		List <WebElement> SecureCheckout = driver.findElements(By.cssSelector("a[href^='javascript']"));
		WebElement Secure = null;
	
			for (WebElement SecureCheck : SecureCheckout) {
				String List = SecureCheck.getText();
				
				System.out.println(List);
				
				if (List.contains("SECURE")) { 
					Secure = SecureCheck;
					System.out.println("Passed");
				}
			}
		Secure.click();
		
		Thread.sleep(3000);
		
		//login use modules here
		WebElement Login = driver.findElement(By.id("UserName"));
		Login.sendKeys("******");
		Thread.sleep(3000);
		WebElement Password = driver.findElement(By.id("UserPwd"));
		Password.sendKeys("*******");
		
		WebElement Submit = driver.findElement(By.id("submit"));
		Submit.click();
		
		//Enters Credentials modules this
		WebElement FirstName = driver.findElement(By.id("SFirstName"));
		FirstName.click();
		FirstName.sendKeys("*****");
		
		
		WebElement LastName = driver.findElement(By.id("SLastName"));
		LastName.click();
		LastName.sendKeys("******");
		
		WebElement Address = driver.findElement(By.id("SAddress1"));
		Address.click();
		Address.sendKeys("*********");
		
		WebElement City = driver.findElement(By.id("SCity"));
		City.click();
		City.sendKeys("***********");
		Thread.sleep(2000);
		
		//selects dropbox menu
		WebElement dropDownListBox = driver.findElement(By.id("SState_Option_USA"));
		Select dropList = new Select(dropDownListBox);
		dropList.selectByVisibleText("NORTH CAROLINA");
		
		
		
		WebElement ZipCode = driver.findElement(By.id("SZip"));
		ZipCode.click();
		ZipCode.sendKeys("27403");
		
		WebElement Phone = driver.findElement(By.id("ShippingPhone"));
		Phone.click();
		Phone.sendKeys("*********");
		
		
		
		
		//unselect box
		WebElement Unselect = driver.findElement(By.id("saveShipping"));
		Unselect.click();
		
		//clicks continue billing
		List <WebElement> Billing = driver.findElements(By.cssSelector("a[href^='javascript']"));	
		WebElement C = null;
		for(WebElement Continue : Billing) {
			String List = Continue.getText();
			System.out.println(List);
			
			if(List.contains("CONTINUE")) {
				C = Continue;
			}
		}
		C.click();
		
		
		
	
		
		
}
	}
