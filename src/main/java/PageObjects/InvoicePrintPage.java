package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractComponents.Abstractcomponents;

public class InvoicePrintPage extends Abstractcomponents{
	
	WebDriver driver;
	
	SoftAssert softAssert = new SoftAssert();
		
	public InvoicePrintPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//h4[normalize-space()='Invoice Print GST']")
	WebElement pageTitle;
	
	public void verifyRecordDisplayInInvoicePrint()
	{
		CashOrderPage cashorder = new CashOrderPage(driver);
		//String generatedInvoiceNo = cashorder.getInvoiceNo();
		//String generatedInvoiceNo = cashorder.invoiceNO;
		System.out.println(cashorder.getInvoiceNo());
		//System.out.println("generated Invoice No is " + generatedInvoiceNo);
		waitForAnElementToAppear(pageTitle);
		List<WebElement> InvoicePrintGridheaders = driver.findElements(By.xpath("//div[@id='UserReportList_wrapper']/table/thead/tr/th"));
		for(int i=1;i<=InvoicePrintGridheaders.size();i++)
		{
			WebElement headerName =InvoicePrintGridheaders.get(i);
			
			if(headerName.getText().equalsIgnoreCase("Invoice No."))
			{
				System.out.println(headerName.getText());
				
				System.out.println(i);
				
				String colno =Integer.toString(i+1);
				
				List<WebElement> invoiceNos =driver.findElements(By.xpath("//tbody/tr/td["+colno+"]"));
				//List<WebElement> invoiceNos =driver.findElements(By.xpath("//tbody/tr/td[4]"));
				
				for(WebElement invoice : invoiceNos)
				{
					System.out.println(invoice.getText());
					 
//					if(invoiceNum.contains(generatedInvoiceNo))
//					{
//						System.out.println(invoiceNum + "Order is displayed in Invoice Print GST");
//					}
//					else
//					{
//						System.out.println("order not displayed");
//					}
				}
				
				
			}
			
			
	
		}
	
	}

}
