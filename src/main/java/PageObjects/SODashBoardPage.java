package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AbstractComponents.Abstractcomponents;

public class SODashBoardPage extends Abstractcomponents{
	
	WebDriver driver;
	
	public SODashBoardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//span[normalize-space()='Masters']")
	WebElement Masters;
	
	@FindBy(xpath="//a[normalize-space()='Duplicate Retailer Merge']")
	WebElement DuplicateRetailerMergermenu;
	
	@FindBy(xpath="//select[@id='TeamDDL']/option[@value='H2']")
	WebElement SelectSHHTeam;
	
	
	
	@Test
	public void verifyMasterMenuDisplay() throws InterruptedException
	{
		Masters.isDisplayed();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(Masters).perform();
		
	}
	
	@Test
	public void duplicateRetailerMergemenudisplay() throws InterruptedException
	{
		
		DuplicateRetailerMergermenu.isDisplayed();
		Thread.sleep(2000);
			
	}
	
	@Test
	public void openDuplicateRetailersMergerPage() throws InterruptedException
	{
		
		DuplicateRetailerMergermenu.click();
		Thread.sleep(2000);
			
	}
	
	
}
