package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AbstractComponents.Abstractcomponents;

public class Expense extends Abstractcomponents{
	
	WebDriver driver;
	
	public Expense(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//a[normalize-space()='Add New Expense']")
	WebElement AddExpense;
	
	@FindBy(xpath="//select[@id='TeamDDL']")
	WebElement Teamdrp;
	
	@FindBy(xpath="//select[@id='TeamDDL']/option[@value='H2']")
	WebElement SelectSHHTeam;
	
	@FindBy(xpath="//input[@id='MonthYDDL']")
	WebElement MonthSelect;
	
	
	public void verifyAllTeamsdisplay()
	{
		boolean found=false;
		AddExpense.click();
		Select select = new Select(Teamdrp);
		List<WebElement> allOptions = select.getOptions();
//		for(WebElement Option : AllOptions)
//		{
//			Option.getText().equalsIgnoreCase("SHH");
//			Option.getText().equalsIgnoreCase("BPC");
//			Option.getText().equalsIgnoreCase("HST");
//			Option.getText().equalsIgnoreCase("CPD");
//		}
		
	}
	
	public void addNewExpense()
	{
		
		AddExpense.click();
		waitForAnElementToAppear(Teamdrp);
		Teamdrp.click();
		Select select = new Select(Teamdrp);
		select.selectByVisibleText("BPC");
		//SelectSHHTeam.click();
				
	}
	

	public void verifyAddedExpense()
	{
		
		
	}

}
