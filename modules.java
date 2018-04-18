import java.io.PrintWriter;
import java.sql.Timestamp;
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
	public static void OpenNewEgg(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		driver.get("https://www.newegg.com");
		printWriter.println(timestamp + " Opens new egg");
		System.out.println(timestamp + " Opens new egg");
		
	}
	
	
	//clicks on log in and register link on the top
	public static void ClickLoginAndRegister(WebDriver driver,  PrintWriter printWriter,Timestamp timestamp) {
		driver.findElement(By.partialLinkText("Log in or Register")).click();
		printWriter.println(timestamp + " Clicks on log in and register link");
		System.out.println(timestamp + " Clicks on log in and register link");
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
	
	
	
	
	
	//find add to cart id and clicks it
	public static void ClickAddToCart(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
				List<WebElement> ClickAdd = driver.findElements(By.id("landingpage-cart"));
				ClickAdd.get(0).click();
				Thread.sleep(2000);
				printWriter.println(timestamp + " Clicks Add to Cart");
				System.out.println(timestamp + " Clicks Add to Cart");
	}
	
	
	
	
	
	// Clicks Secure Checkout 
	public static void ClickSecureCheckout(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
	
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
		printWriter.println(timestamp + " Clicks Secure Checkout");
		System.out.println(timestamp + " Clicks Secure Checkout");
	}
	
	//clicks guest checkout
	public static void ClickGuestCheckout(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		
		WebElement Click = driver.findElement(By.xpath("//button[contains(.,'Continue as a Guest')]"));
		Click.click();
		
		printWriter.println(timestamp + " Clicks on Guest Checkout");
		System.out.println(timestamp + " Clicks on Guest Checkout");
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
	
	
	
	
	
	
	//clicks on the product based on the order of the products displayed
	public static void ClickOnItem(WebDriver driver, int ItemNumberOnList, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
		//clicks on the the item on the list and list items on the webpage
		List<WebElement> Products = driver.findElements(By.className("item-title"));
		Products.get(ItemNumberOnList-1).click();
		Thread.sleep(2000);
		printWriter.println(timestamp + " Clicks on item");
		System.out.println(timestamp + " Clicks on item");
	}
	
	
	//clicks on the view item link
	public static void ClickViewItem( WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		//view shopping cart
		driver.findElement(By.partialLinkText("Items")).click();
		printWriter.println(timestamp + " Clicks view item ");
		System.out.println(timestamp + " Clicks view item");
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
	
	
	
	
	
	//inputs login information 
	public static void Login(WebDriver driver, String User, String Pass, PrintWriter printWriter, Timestamp timestamp) throws InterruptedException {
		//login information
				WebElement Username = driver.findElement(By.id("UserName"));
				Username.sendKeys(User);
				Thread.sleep(3000);
				WebElement Password = driver.findElement(By.id("UserPwd"));
				Password.sendKeys(Pass);
				
				WebElement Submit = driver.findElement(By.id("submitLogin"));
				Submit.click();
				
				printWriter.println(timestamp + " Logs in successfully");
				System.out.println(timestamp + " Logs in successfully");
	}
	
	
	
	
	
	
	
	
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
	
	
	
	//inputs information for guest account
	public static void GuestAddress(WebDriver driver, JavascriptExecutor js, WebDriverWait wait, String FName, String LName, String AddressLine1, String EnterCity, String DropStateList, String EnterZip, String PhoneNumber, String UnregisteredEmail, PrintWriter printWriter, Timestamp timestamp ) throws InterruptedException {
		
		
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
		
		printWriter.println(timestamp + " Fills in Shipping Information");
		System.out.println(timestamp + " Fills in Shipping Information");
		
		
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
	
	


	
	
	

	
	
	
	//Test Case Pass Message
	public static void TestCasePassed(PrintWriter printWriter, Timestamp timestamp) {
		printWriter.println(timestamp + " This test case passed all of it's credentials");
		System.out.println(timestamp + " This test case passed all of it's credentials");
	}
	
	//clicks on track order on the webpage
	public static void ClickTrackOrder(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		WebElement TrackOrder = driver.findElement(By.id("trackOrder"));
		TrackOrder.click();
		printWriter.println(timestamp + " Clicks on Track Order on Homepage");
		System.out.println(timestamp + " Clicks on Track Order on Homepage");
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
	
	//inputs order number information for guests or without login
	public static void OrderNumberInformation(WebDriver driver, String OrderNumber, String ZipCodeOREmail, PrintWriter printWriter, Timestamp timestamp) {
		int ok_size=driver.findElements(By.name("GuestOrderNumber")).size();
		List<WebElement> Order = driver.findElements(By.name("GuestOrderNumber"));
		Order.get(ok_size-1).sendKeys(OrderNumber);
		
		WebElement ZipOrEmail = driver.findElement(By.name("GuestEmailZipCode"));
		ZipOrEmail.sendKeys(ZipCodeOREmail);
		printWriter.println(timestamp + " Fills in Order information");
		System.out.println(timestamp + " Fills in Order information");
	
	}
	
	//clicks find history
	public static void ClickFindHistory(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		WebElement Click = driver.findElement(By.xpath("//button[contains(.,'Find My Order ')]"));
		Click.click();
		printWriter.println(timestamp + " Clicks Find History");
		System.out.println(timestamp + " Clicks Find History");
	}
	
	
	
	//clicks on 72 deals link on the homepage
	public static void ClickOnSeventyTwoDeals(WebDriver driver, JavascriptExecutor js, PrintWriter printWriter, Timestamp timestamp ) throws InterruptedException {
		List <WebElement> SeventyTwoDeals = driver.findElements(By.cssSelector("a[href^='//www.newegg.com/DailyDeal.aspx?name=DailyDeal&cm_sp=Dailydeal-_-adlink-_-04182018"));
		SeventyTwoDeals.get(0).click();
		Thread.sleep(3000);
		printWriter.println(timestamp + " Clicks on Seventy two deals on homepage");
		System.out.println(timestamp + " Clicks on Seventy two deals on homepage");
		
	}
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
	
	
	public static void InputRegistrationInfo(WebDriver driver, String FName, String LName, String InputEmail, String Pass, PrintWriter printWriter,Timestamp timestamp) throws InterruptedException {
		
		WebElement FirstName = driver.findElement(By.name("FirstName"));
		FirstName.sendKeys(FName);
		Thread.sleep(3000);
		
		WebElement LastName = driver.findElement(By.name("LastName"));
		LastName.sendKeys(LName);
		Thread.sleep(3000);
		
		WebElement Email = driver.findElement(By.name("LoginName"));
		Email.sendKeys(InputEmail);
		Thread.sleep(3000);
		
		WebElement Password = driver.findElement(By.name("Password"));
		Password.sendKeys(Pass);
		Thread.sleep(3000);
		
		WebElement Click = driver.findElement(By.id("submitRegistration"));
		Click.click();
		
		printWriter.println(timestamp + " Registration info has been filled properly");
		System.out.println(timestamp + " Registration info has been filled properly");
		
		
	}
	
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
	
	public static void ViewEditAddress(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
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
	
	
	//clicks My Dashboard on the homepage
	
	public static void ClickMyDashboard(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		WebElement Dashboard = driver.findElement(By.partialLinkText("My Dashboard"));
		Dashboard.click();
		
		printWriter.println(timestamp + " Clicks on dashboard on the homepage");
		System.out.println(timestamp + " Clicks on dashboard on the homepage");
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
	
	//clicks on sign up for registration
	public static void ClickSignUpLink(WebDriver driver) {
		WebElement SignUp = driver.findElement(By.partialLinkText("Sign up"));
		SignUp.click();
		
	}
	
	//clicks on address book
	public static void ClickAddressBook(WebDriver driver, PrintWriter printWriter, Timestamp timestamp) {
		WebElement ClickAddressBook = driver.findElement(By.partialLinkText("Address Book"));
		ClickAddressBook.click();
		printWriter.println(timestamp + " Clicks on address book");
		System.out.println(timestamp + " Clicks on address book");
		
		
	}

	
	
	
}