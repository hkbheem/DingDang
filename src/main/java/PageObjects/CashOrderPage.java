package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import AbstractComponents.Abstractcomponents;

public class CashOrderPage extends Abstractcomponents{
	
	WebDriver driver;
	
	String docNo;
	
	String invoiceNO;
	
	SoftAssert softAssert = new SoftAssert();
			
			
	public CashOrderPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setInvoiceNo(String invoiceNumber)
	{
		
		this.invoiceNO=invoiceNumber;
	}
	
	public String getInvoiceNo()
	{
		return invoiceNO;
		
	}
	

	@FindBy(xpath="//select[@id='DDLTeam']")
	WebElement TeamSelect;
	
	@FindBy(xpath="//select[@id='Cashorder_status']")
	WebElement OrderType;

	@FindBy(xpath="//select[@id='RetailerName']")
	WebElement Retailer;
	
	public void addDivisionTeamdetails()
	{
		Select selectteam = new Select(TeamSelect);
		selectteam.selectByVisibleText("URBAN");
		Select selectordertype = new Select(OrderType);
		selectordertype.selectByVisibleText("Retailer Order");
		waitForAnElementToAppear(Retailer);
		
	}
	
	@FindBy(xpath="//button[@id='createOrder']")
	WebElement CreateOrder;
	
	@FindBy(xpath="//select[@id='ProductList']")
	WebElement Productlist;
	
	public void addRetailerDetails(String RetailerName)
	{
		Select selectretailer = new Select(Retailer);
		selectretailer.selectByVisibleText(RetailerName);
		CreateOrder.click();
		waitForAnElementToAppear(Productlist);
	}
	
	@FindBy(xpath="//input[@id='OrderQty']")
	WebElement OrderQty;
	
	@FindBy(xpath="//button[@id='AddProductButton']")
	WebElement AddProduct;
	
	@FindBy(xpath="//div[@id='order_formFileds']")
	WebElement Productgrid;
	
	public void addProductstoGrid(String ProductName, String Qty) throws InterruptedException
	{
		Select selectproduct = new Select(Productlist);
		selectproduct.selectByVisibleText(ProductName);
		OrderQty.sendKeys(Qty);
		AddProduct.click();
		waitForAnElementToAppear(Productgrid);
		softAssert.assertTrue(Productgrid.isEnabled());
	
	}

	@FindBy(xpath="//div[@id='ProductDetailTable_wrapper']/div/div[2]/table/tbody")
	WebElement Grid;
	 
	@SuppressWarnings("unlikely-arg-type")
	public void verifyAddedProductDisplay()
	{
	
		List<WebElement> GridProductList =driver.findElements(By.xpath("//div[@id='ProductDetailTable_wrapper']/div/div[2]/table/tbody/tr/td[2]"));
		if(GridProductList.contains("ProductName"));
		{
			softAssert.assertTrue(Grid.isEnabled());
		}
		
		
	}
	
	@FindBy(xpath="//a[@id='PreviewButton']")
	WebElement Preview;
	
	@FindBy(xpath="//a[@class='btn btn-custom btn-view u-flex-all PreviewOrderDetails']")
	WebElement PreviewInvoice;
	
	@FindBy(xpath="//div[@id='previewModal']//button[@id='DocumentClose']")
	WebElement PreviewPopupClose;
	
	@FindBy(xpath="//a[@id='SavePreview']")
	WebElement SaveOrder;
	
	public void previewInvoiceDetails() throws InterruptedException
	{
		Preview.click();
		Thread.sleep(2000);
		waitForAnElementToAppear(SaveOrder);
		PreviewInvoice.click();
		PreviewPopupClose.click();
	}
	
	@FindBy(xpath="//div[@class='btn-group']//a[@id='HoldButton']")
	WebElement hold;

	@FindBy(xpath="//button[@id='ConfirmOKbutton']")
	WebElement holdconfirm;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement holdsuccessMessage;
	
	public void holdOrder()
	{
		waitForAnElementToAppear(SaveOrder);
		hold.click();
		holdconfirm.click();
		if(holdsuccessMessage.isDisplayed())
		{
			String DocNo= holdsuccessMessage.getText();
			String[] DocumentNo = DocNo.split(" ");
			System.out.println(DocumentNo[0]);
		}
	
	}
	

	@FindBy(xpath="//h4[normalize-space()='DeliveryAndInvoice']")
	WebElement OrderSaved;
	
	public void saveOrder()
	{
		SaveOrder.click();
		waitForAnElementToAppear(OrderSaved);
		if(OrderSaved.isDisplayed())
		{
			System.out.println("Order Creates Successfully");
		}
	}
	
	@FindBy(xpath="//button[@id='btn_DelvrConfrm']")
	WebElement DeliveryConfirm;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement ConfirmOrder;
	
	@FindBy(xpath="//button[@id='GenerateInvoice']")
	WebElement ConfirmPopup;
	
	@FindBy(xpath="//div[@id='AlertDialogMessage']")
	WebElement ConfirmedMessage;
	
	@FindBy(xpath="//div[@class='modal-dialog']//button[@id='AlertDialogOKButton']")
	WebElement AlertOkButton;
	
	public void confirmDelivery()
	{
		DeliveryConfirm.click();
		waitForAnElementToAppear(ConfirmOrder);
		ConfirmOrder.click();
		ConfirmPopup.click();
		waitForAnElementToAppear(ConfirmedMessage);
		String successMessage = ConfirmedMessage.getText();
		
		String[] message = successMessage.split(" ");
		
		String invoiceNumber =(message[1]);
		
		CashOrderPage cashordr= new CashOrderPage(driver);
		cashordr.setInvoiceNo(invoiceNumber);
		System.out.println("GET Invoice No from CashOrderPage " + cashordr.getInvoiceNo());
	//	System.out.println(cashordr.getInvoiceNo());
		
		System.out.println("confirm delivery" + invoiceNumber);
		if(successMessage.endsWith("successfully."))
		{
			System.out.println(successMessage);
			AlertOkButton.click();
		}
		
	}


}
