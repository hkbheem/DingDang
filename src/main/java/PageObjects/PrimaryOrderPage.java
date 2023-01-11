package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.Abstractcomponents;

public class PrimaryOrderPage extends Abstractcomponents{
	
	WebDriver driver;
	public PrimaryOrderPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//select[@id='TeamCode']")
	WebElement Team;

	@FindBy(css="select[id='TeamCode'] option[value='CPD']")
	WebElement SelectTeam;
	
	@FindBy(xpath="//button[@id='POConfirmOKbutton1']")
	WebElement NotePopupClose;

	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	WebElement ProductNamedropdown;

//	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("7002467");
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement SearchProduct;
	
//	driver.findElement(By.xpath("//input[@value='7002467']")).click();
	@FindBy(xpath="//input[@value='7002467']")
	WebElement SelectProduct;

//	driver.findElement(By.xpath("//button[@id='btnAdd']")).click();
	@FindBy(xpath="//button[@id='btnAdd']")
	WebElement AddProductToGrid;

//	driver.findElement(By.xpath("//input[@name='ShipperQty_7002467']")).sendKeys("5");
	@FindBy(xpath="//input[@name='ShipperQty_7002467']")
	WebElement EnterShipperQty;

//	driver.findElement(By.xpath("//button[@id='btnSaveManualOrder']")).click();
	@FindBy(xpath="//button[@id='btnSaveManualOrder']")
	WebElement SavePrimaryOrder;

//	driver.findElement(By.xpath("//input[@id='Remarks']")).sendKeys("Primary Order");
	@FindBy(xpath="//input[@id='Remarks']")
	WebElement EnterRemarks;
	
//	driver.findElement(By.xpath("//button[@id='save']")).click();
	@FindBy(xpath="//button[@id='save']")
	WebElement ConfirmOrder;
	
// //button[@id='ConfirmOKbutton']
	@FindBy(xpath="//button[@id='ConfirmOKbutton']")
	WebElement ConfirmDialog;
	
//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='Remarks']"))));
	
	
	public void SubmitPrimaryOrder(String ProductCode, String Qty, String remarks) throws InterruptedException
	{
		Thread.sleep(3000);
		Team.click();
		SelectTeam.click();
		waitForAnElementToAppear(NotePopupClose);
		Thread.sleep(6000);
		NotePopupClose.click();
		ProductNamedropdown.click();
		SearchProduct.sendKeys(ProductCode);
		SelectProduct.click();
		AddProductToGrid.click();
		waitForAnElementToAppear(EnterShipperQty);
		EnterShipperQty.sendKeys(Qty);
		SavePrimaryOrder.click();
		waitForAnElementToAppear(EnterRemarks);
		EnterRemarks.sendKeys(remarks);
		ConfirmOrder.click();
		waitForAnElementToAppear(ConfirmDialog);
		ConfirmDialog.click();
			
	}


}
