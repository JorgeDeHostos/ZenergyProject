import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class modules {
	
	
	//opens the website new egg
	public static void OpenNewEgg(WebDriver driver) {
		driver.get("https://www.newegg.com");
		
	}
	
	
	//clicks on log in and register link on the top
	public static void ClickLoginAndRegister(WebDriver driver) {
		driver.findElement(By.partialLinkText("Log in or Register")).click();
	}
	
	
	//searches for specific product
	public static void ProductSearch(WebDriver driver, String Product) {
	
		WebElement Search = driver.findElement(By.id("haQuickSearchBox"));
		
		Search.click();
		Search.sendKeys(Product);
		Search.submit();
	}
	
	
	
	
	
	//find add to cart id and clicks it
	public static void ClickAddToCart(WebDriver driver) throws InterruptedException {
						List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
				ClickAdd.get(0).click();
				Thread.sleep(2000);
	}
	
	
	
	
	
	// Clicks Secure Checkout 
	public static void ClickSecureCheckout(WebDriver driver) throws InterruptedException {
	
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
	}
	
	//clicks guest checkout
	public static void ClickGuestCheckout(WebDriver driver) {

		List <WebElement> Guest = driver.findElements(By.cssSelector("a[href^='javascript']"));	
		WebElement C = null;
		for(WebElement Click : Guest) {
			String List = Click.getText();
			
			if(List.contains("GUEST")) {
				C = Click;
			}
		}
		C.click();
	}
	
	
	//clicks continue billing
	public static void ClickContinueBilling(WebDriver driver) {
		
		List <WebElement> Billing = driver.findElements(By.cssSelector("a[href^='javascript']"));	
		WebElement C = null;
		for(WebElement Continue : Billing) {
			String List = Continue.getText();
			
			if(List.contains("CONTINUE")) {
				C = Continue;
			}
		}
		C.click();
	}
	
	
	
	
	
	
	//clicks on the product based on the order of the products displayed
	public static void ClickOnItem(WebDriver driver, int ItemNumberOnList) throws InterruptedException {
		//clicks on the the item on the list and list items on the webpage
		List<WebElement> Products = driver.findElements(By.className("item-title"));
		Products.get(ItemNumberOnList-1).click();
		Thread.sleep(2000);
	}
	
	
	//clicks on the view item link
	public static void ClickViewItem( WebDriver driver) {
		//view shopping cart
		driver.findElement(By.partialLinkText("Items")).click();
			
	}
	
	
	//lists products on the page
	public static void ListItemOnProductSearch(WebDriver driver) {
		List<WebElement> Products = driver.findElements(By.className("item-title"));
		System.out.println("This is the list of items:");
		
		for(WebElement ProductList : Products) {
			String List = ProductList.getText();
			System.out.println(List);
		}
	
	
	}
	
	
	
	
	
	//inputs login information 
	public static void Login(WebDriver driver, String User, String Pass) throws InterruptedException {
		//login information
				WebElement Username = driver.findElement(By.id("UserName"));
				Username.sendKeys(User);
				Thread.sleep(3000);
				WebElement Password = driver.findElement(By.id("UserPwd"));
				Password.sendKeys(Pass);
				
				WebElement Submit = driver.findElement(By.id("submit"));
				Submit.click();
	}
	
	
	
	
	
	
	
	
	// inputs information for an actual account
	public static void ShippingAddress(WebDriver driver, JavascriptExecutor js, String FName, String LName, String AddressLine1, String EnterCity, String DropStateList, String EnterZip, String PhoneNumber) throws InterruptedException{
		
		
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
	}
	
	
	
	//inputs information for guest account
	public static void GuestAddress(WebDriver driver, JavascriptExecutor js, WebDriverWait wait, String FName, String LName, String AddressLine1, String EnterCity, String DropStateList, String EnterZip, String PhoneNumber, String UnregisteredEmail ) throws InterruptedException {
		
		
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("GuestEmail")));
		int ok_size=driver.findElements(By.name("GuestEmail")).size();
		List<WebElement> Email = driver.findElements(By.name("GuestEmail"));
		Email.get(ok_size-1).sendKeys(UnregisteredEmail);
		
		
	}
	
	
	
	
	//checks title of the page
	public static void CheckTitleOnPage(WebDriver driver, String expectedTitle) {
		
		String titleExpected = expectedTitle;
		String actualTitle ="";
		
		//gets actual string/value of the title
		actualTitle = driver.getTitle();
		
		//compares actual title with expected title with if else statements
		
		if(actualTitle.contentEquals(titleExpected)) {
			System.out.println("Test Passed!");
			System.out.println("The "+ "expected title: \""+expectedTitle + "\" = "+"actual title: \"" + actualTitle+"\"" );
		}else {
			System.out.println("Test Failed!");
			System.out.println("The "+"expected title: \""+ expectedTitle + "\" does not equal "+"actual title: \"" + actualTitle+"\"" );
		}
	}
	
	

	
	//clicks Create New Account after the log in and register link
	public static void ClickCreateNewAccount(WebDriver driver) {
		List <WebElement> ClickCreateAccount = driver.findElements(By.name("submit"));
		ClickCreateAccount.get(1).click();
	}
	
	
	
	
	//inputs registrations information
	public static void RegistrationInformation(WebDriver driver, String email, String password ) {
		WebElement Email = driver.findElement(By.name("LoginName"));
		Email.click();
		Email.sendKeys(email);
		
		
		WebElement ReEnterEmail = driver.findElement(By.name("LoginName1"));
		ReEnterEmail.click();
		ReEnterEmail.sendKeys(email);
		
		WebElement Password = driver.findElement(By.name("Password"));
		Password.click();
		Password.sendKeys(password);
		
		WebElement ReEnterPassword = driver.findElement(By.name("Password1"));
		ReEnterPassword.click();
		ReEnterPassword.sendKeys(password);
		
	}
	
	
	
	//Clicks on Create Account after registration information input
	public static void ClickCreateAccount(WebDriver driver) {
		List <WebElement> CreateAccount = driver.findElements(By.cssSelector("a[href^='javascript']"));
		WebElement C = null;
		for(WebElement Create : CreateAccount) {
			String List = Create.getText();
			System.out.println(List);
			
			if(List.contains("CREATE")) {
				C = Create;
			}
		
		
		}
		C.click();
		
	}
	
	
	
	//Test Case Pass Message
	public static void TestCasePassed() {
		System.out.println("This test case passed all of its credentials");
	}
	
}
