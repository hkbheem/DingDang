package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.landingPage;
import TestComponents.BaseTest;

public class Login extends BaseTest{
	
	
	@Test
	public void verifyloginwithValidCreds() throws IOException
	{
	initializeDriver();
	landingPage landPage = new landingPage(driver);
	landPage.LoginToApplication("703680", "703680SONU1");
	driver.close();

	}
	
	
	@Test
	public void verifyloginwithInValidCreds() throws IOException
	{		
		initializeDriver();
		landingPage landPage = new landingPage(driver);
		landPage.verifyLoginforInvalidCreds("703680", "703680SONU");
		driver.close();
		
	}
	

}
