package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import AbstractComponents.Abstractcomponents;


public class SalesOrderDelivery extends Abstractcomponents{
	
	WebDriver driver;
	public SalesOrderDelivery(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Test
	public void CashOrder()
	{
		
		
	}

}
