package testcases;

import com.google.inject.Module;

//extends ModuleMethods, no import needed here

public class guestcheckout extends ModuleMethods{
	public static void main(String[] args) throws InterruptedException {
		ModuleMethods modules = new ModuleMethods();
		ModuleMethods.main(args);
		modules.openNewEgg();
		/*Copy above 4 lines for new test cases*/
		
		modules.search();	
		modules.selectItem();
		//driver.get("https://www.newegg.com/Product/Product.aspx?Item=N82E16814131720&cm_re=AMD_RX_580-_-14-131-720-_-Product");
		modules.addWarrenty();
		modules.addtoCart();
		modules.viewCartAfterAddtoCart();
		modules.secureCheckout();
	}
}
