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
	

	
	
	
	
	
	
	


	
	

	

	


	
	
	
	
	
	

	
	

	

	


	
	
	
}