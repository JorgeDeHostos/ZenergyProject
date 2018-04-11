import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseProductSearch {
	public static void main(String[] args) throws InterruptedException {
		String os = System.getProperty("os.name").toLowerCase();
		//implements google chrome
		
		
		//if its mac or windows
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		}else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		//opens newegg
		modules.OpenNewEgg(driver);
		
		//searches string that you want to search
		modules.ProductSearch(driver, "Tower");
		
		//checks valid title of the page and product matches
		modules.CheckTitleOnPage(driver, "Tower - Newegg.com");
		
		System.out.println("");


		
		
		
		//list the items on the webpage
		modules.ListItemOnProductSearch(driver);
		
		//clicks on item list that you want to click on I decide to pick the 1st item on the list
		modules.ClickOnItem(driver, 3);
		
		Thread.sleep(5000);
		
		driver.quit();
		
		// if all of the modules work it should display message that says the test has passed
		modules.TestCasePassed();
		
		
		
}
}
