package prvt.gabbster;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RevisionTest extends Generic_Test {

	@Test
	@Parameters({ "phoneNumber", "webDriver", "carModel" })
	public void OrderRevisionParts(String phoneNumber, String webDriver, String carModel)
			throws IOException, InterruptedException {

		initializeVariables(phoneNumber, webDriver, carModel);
		
		WebDriver pcdriver = DesktopPrepare(getWebDriver());

		System.out.println(getWebDriver());
		InspectionParts(pcdriver, carModel);
		ShippingDetails(pcdriver);
		
	}

}
