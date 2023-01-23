package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AbstractComponents.Abstractcomponents;

public class StockTransferPage extends Abstractcomponents{
	
	WebDriver driver;
	
	public StockTransferPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//h4[normalize-space()='Stock Transfer List']")
	WebElement StockTransferPageTitle;
	
	@FindBy(xpath="//a[normalize-space()='Add New']")
	WebElement AddNewStockTransfer;
	
	@FindBy(xpath="//h4[normalize-space()='Stock Transfer Details']")
	WebElement AddStockTransferPage;
	
	@FindBy(xpath="//select[@id='TeamCode']")
	WebElement selectTeam;
	
//	@FindBy(xpath="//select[@id='DistributorCode']")
//	WebElement selectDist;
	
	@FindBy(xpath="//a[@class='chosen-single']")
	WebElement distDropdown;
	
	@FindBy(xpath="//div[@class='chosen-search']//input[@type='text']")
	WebElement searchDist;
	
	@FindBy(xpath="(//ul[@class='chosen-results'])[1]")
	WebElement selectDist;
	
	
	
	@FindBy(xpath="//div[@class='loader_inner']")
	WebElement loaderIcon;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement SaveStockTransfer;
	
	@FindBy(xpath="//button[@id='ConfirmOKbutton']")
	WebElement ConfirmStockTransfer;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement SuccessAlert;
	
	

	public void createStockTransfer(String ToDistributor, String Qty) throws InterruptedException
	{
		waitForAnElementToAppear(StockTransferPageTitle);
		AddNewStockTransfer.click();
		waitForAnElementToAppear(AddStockTransferPage);
		Select select = new Select(selectTeam);
		select.selectByVisibleText("SHH");
		Thread.sleep(3000);
		distDropdown.click();
		searchDist.sendKeys(ToDistributor);
		selectDist.click();
//		waitForAnElementToAppear(selectDist);
//		Select selectdist = new Select(selectDist);
//		selectdist.selectByVisibleText(ToDistributor);
		waitForInvisibilityofElement(loaderIcon);
		for(int i=1; i<3;i++)
		{
			for(int j=10;j<=10;j++)
			{
				String rowno = Integer.toString(i);
				System.out.println(rowno);
				String colno = Integer.toString(j);
				System.out.println(colno);
				driver.findElement(By.xpath("//table[@id='StockTransferAddList']/tbody/tr["+rowno+"]/td["+colno+"]/input[1]")).sendKeys(Qty);
			}
		}
		SaveStockTransfer.click();
		ConfirmStockTransfer.click();
		waitForAnElementToAppear(SuccessAlert);
		System.out.println(SuccessAlert.getText());
	}

}
