package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.DashBoard;
import PageObjects.Expense;
import PageObjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Claims {
	
	
	@Test
	public void addExpense()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://leapqa.himalayawellness.com/IODP/Account/Login");
		driver.manage().window().maximize();
		
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("703680", "703680SONU1");
		
		DashBoard dashboard = new DashBoard(driver);
		dashboard.verifyExpensepagedisplay();
		
//		Expense expense = new Expense(driver);
//		expense.addNewExpense();		
		
	}

}
