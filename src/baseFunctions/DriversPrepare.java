package baseFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriversPrepare {

	public static WebDriver DesktopPrepare(String WebDriver) {
		//Initialize WebDriver
		WebDriver pcdriver = null;

		//If wanted browser is Firefox
		if (WebDriver.equals("firefox")) {
			//Set the path for Firefox driver
			System.setProperty("webdriver.gecko.driver",
					"C:\\_DiskD\\Programare\\Git\\AutomationTests\\libs\\geckodriver.exe");
			pcdriver = new FirefoxDriver();
			
			//Add implicitly wait of 20 seconds
			pcdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			return pcdriver;
		}
		//If wanted browser is Chrome
		else if(WebDriver.equals("chrome")) {
			//Set the path for Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\_DiskD\\Programare\\Git\\AutomationTests\\libs\\chromedriver.exe");
			pcdriver = new ChromeDriver();
			
			//Add implicitly wait of 20 seconds
			pcdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			return pcdriver;
		}

		return null;
	}

}
