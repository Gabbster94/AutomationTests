package prvt.gabbster;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Generic_Test extends Base {

	public void initializeVariables(String phoneNumber, String webDriver, String carModel) {
	setPhoneNumber(phoneNumber);
	setWebDriver(webDriver);
	setCarModel(carModel);
	}
	

	//@Test
	public void test() {
		WebDriver pcdriver = DesktopPrepare("firefox");
	}
}
