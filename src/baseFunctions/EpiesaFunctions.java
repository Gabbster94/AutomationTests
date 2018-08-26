package baseFunctions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EpiesaFunctions {

	@SuppressWarnings("unused")
	public void LogIn(WebDriver pcdriver) throws IOException {

		// Navigate to epiesa
		pcdriver.get("http://epiesa.ro/");

		// Open login page and login
		pcdriver.findElement(By.linkText("LOGIN/")).click();
		pcdriver.findElement(By.xpath("//input[@name= 'login_utilizator']"))
				.sendKeys(GetDataFromFile.getUsernameFromFile("epiesa"));
		pcdriver.findElement(By.xpath("//input[@name= 'login_parola']"))
				.sendKeys(GetDataFromFile.getPasswordFromFile("epiesa"));
		pcdriver.findElement(By.xpath("//input[@value = 'AUTENTIFICARE']")).click();
	}

	public void InpectionParts(WebDriver pcdriver, String CarModel) throws IOException, InterruptedException {
		//Log into Epiesa
		LogIn(pcdriver);
		Thread.sleep(1000);
		
		//Open "Piese Auto" page
		pcdriver.findElement(By.linkText("Piese auto")).click();
		
		//If CarModel is: Honda
		if(CarModel.equals("Honda")) {
			// select Marca HONDA
			WebElement marca = pcdriver
					.findElement(By.xpath("/html/body/div[1]/section[1]/div[2]/div[2]/form/div[1]/div/div/select"));
			Select omarca = new Select(marca);
			omarca.selectByVisibleText("HONDA");

			// select Modelul CIVIC
			WebElement model = pcdriver.findElement(By.xpath("//*[@id=\"select2\"]"));
			Select omodel = new Select(model);
			omodel.selectByVisibleText("CIVIC VIII Hatchback (FN, FK) (2005 - prezent)");

			// click on motorizare 1.8 benzina
			pcdriver.findElement(By.linkText("R18A2")).click();

			// click on filtru de aer
			pcdriver.findElement(By.linkText("Filtru aer")).click();
			pcdriver.findElement(
					By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[3]/div[8]/div[2]/div[2]/div[2]/form/a")).click();

			// go back to piese auto
			pcdriver.navigate().back();
			pcdriver.navigate().back();

			// click on polen
			pcdriver.findElement(By.linkText("Filtru polen")).click();
			pcdriver.findElement(
					By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[3]/div[15]/div[2]/div[2]/div[2]/form/a")).click();

			// go back to piese auto
			pcdriver.navigate().back();
			pcdriver.navigate().back();

			// click on filtru ulei
			pcdriver.findElement(By.linkText("Filtru ulei")).click();
			pcdriver.findElement(
					By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[3]/div[18]/div[2]/div[2]/div[2]/form/a")).click();

			// search in 'cauta dupa cod piesa' and Adauga Cos ulei motor castrol edge 5w30
			// 4L
			WebElement uleimotor = pcdriver.findElement(By.xpath("/html/body/div[1]/header/div[2]/form/div[2]/input"));
			uleimotor.sendKeys("ULEI MOTOR CASTROL EDGE TITANIUM LL 5W30 4L" + Keys.ENTER);
			pcdriver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div[2]/div/div[2]/form/a"))
			.click();
		}
		//If CarModel is: VW

	}

	public void ShippingDetails(WebDriver pcdriver) {
		
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Initilize pcdriver
		WebDriver pcdriver = null;
		pcdriver = DriversPrepare.DesktopPrepare("firefox");
		
		//Create object of Epiesa Function class
		EpiesaFunctions EpiesaFunc = new EpiesaFunctions();
		
		// Call EpiesaFunctions -> LogIn
		//EpiesaFunc.LogIn(pcdriver);
		
		//Call InspectionParts method
		EpiesaFunc.InpectionParts(pcdriver, "Honda");
	}

}
