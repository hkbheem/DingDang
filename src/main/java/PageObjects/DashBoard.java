package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractComponents.Abstractcomponents;


public class DashBoard extends Abstractcomponents{
	
	WebDriver driver;
	
	public DashBoard(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Primary Order']")
	WebElement PrimaryOrder;
	
	@FindBy(xpath="//a[normalize-space()='Manual Primary Order']")
	WebElement ManualPrimaryOrder;
	
	@FindBy(xpath="//div[@id='InfoPopUp']//button[@id='DocumentClose']")
	WebElement Infopopup;
		
	public void ManualPrimaryOrder() throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(PrimaryOrder).build().perform();
		Thread.sleep(3000);
		ManualPrimaryOrder.click();		
		//Infopopup.click();
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Sales Order Delivery']")
	WebElement SalesOrder;
	
	@FindBy(xpath="//a[normalize-space()='Cash Order']")
	WebElement CashOrder;
	
	@FindBy(xpath="//select[@id='DDLTeam']")
	WebElement Teamdropdown;
	
	public void SecondaryOrder()
	{
		Actions a = new Actions(driver);
		a.moveToElement(SalesOrder).build().perform();
		CashOrder.click();
		waitForAnElementToAppear(Teamdropdown);
	}
	
	@FindBy(xpath="//body/header[@id='topnav']/div[@class='navbar-custom']/div[@class='topbar-main__mainmenu']/div[@class='container pad-0']/ul[@id='navigation']/li/ul[@class='navigation-menu']/li[10]/a[1]")
	WebElement Claims;
	
	@FindBy(xpath="//a[normalize-space()='Expense']")
	WebElement expense1;
	
	@FindBy(xpath="//div[@class='col-xs-4']/h4[@class='page-title']")
	WebElement pageName;
	
	
	public void verifyExpensepagedisplay()
	{
		
		Actions a = new Actions(driver);
		a.moveToElement(Claims).perform();
		a.moveToElement(expense1).click();
		expense1.click();
		String pageTitle = pageName.getText();
		SoftAssert sa = new SoftAssert();
		System.out.println(pageTitle);
		sa.assertEquals(pageTitle, "Expense ddDetails");
		sa.fail(pageTitle + "failed");
		driver.close();
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Print Invoice GST']")
	WebElement InvoicePrint;
	
	
	
	public void invoicePrintGST()
	{
		Actions a = new Actions(driver);
		a.moveToElement(SalesOrder).perform();
		InvoicePrint.click();
			
	}
	
	@FindBy(xpath="//a[normalize-space()='Hold Order List']")
	WebElement HoldOrderListSubmenu;
	
	public void openHoldOrderList()
	{
		Actions a = new Actions(driver);
		a.moveToElement(SalesOrder).perform();
		HoldOrderListSubmenu.click();
		
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Stock']")
	WebElement Stock;

	@FindBy(xpath="//a[normalize-space()='Stock Transfer']")
	WebElement StockTransfer;
	
	public void stockTransfer()
	{
		Actions a = new Actions(driver);
		a.moveToElement(Stock).perform();
		StockTransfer.click();	
	}
	
	@FindBy(xpath="//span[normalize-space()='Masters']")
	WebElement Masters;
	
	@FindBy(xpath="//a[normalize-space()='Duplicate Retailer Merge']")
	WebElement DuplicateRetailerMerge;
	
	@FindBy(xpath="//h4[normalize-space()='Duplicate Retailer Merge']")
	WebElement pageHeader;
	
	public void DuplicateRetailersMerge()
	{
		Actions a = new Actions(driver);
		a.moveToElement(Masters).perform();
		DuplicateRetailerMerge.isDisplayed();
		DuplicateRetailerMerge.click();
		
	}
	

}
