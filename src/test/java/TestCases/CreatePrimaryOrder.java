package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.DashBoard;
import PageObjects.PrimaryOrderPage;
import PageObjects.landingPage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePrimaryOrder extends BaseTest{
	

	@Test
	public void createPrimaryOrder() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://leapqa.himalayawellness.com/IODP/Account/Login");
		driver.manage().window().maximize();
		
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("703680", "*");
		
		DashBoard dashboard = new DashBoard(driver);
		dashboard.ManualPrimaryOrder();
		
		PrimaryOrderPage primaryOrder = new PrimaryOrderPage(driver);
		primaryOrder.SubmitPrimaryOrder("7002467", "5", "Primary Order");
		

	}

}
