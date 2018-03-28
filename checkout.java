package testcases;

import org.openqa.selenium.By;

//extends ModuleMethods, no import needed here 

public class checkout extends ModuleMethods{
	public static void main(String[] args) throws InterruptedException {
		ModuleMethods modules = new ModuleMethods();
		ModuleMethods.main(args);
		modules.openNewEgg();
		/*Copy above 4 lines for new test cases*/
		
		modules.search();
		modules.selectItem();
		modules.addWarrenty();
		modules.addtoCart();
		modules.viewCartAfterAddtoCart();
		
	}
	

}
