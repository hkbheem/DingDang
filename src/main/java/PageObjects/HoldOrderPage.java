package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import AbstractComponents.Abstractcomponents;

public class HoldOrderPage extends Abstractcomponents{
	
	WebDriver driver;
	
//	SoftAssert softAssert = new SoftAssert();
		
	public HoldOrderPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h4[normalize-space()='CashOrder Hold List']")
	WebElement HoldOrderpageTitle;
	
	public void holdOrders()
	{
		waitForAnElementToAppear(HoldOrderpageTitle);
		List<WebElement> HoldOrderGridheaders =driver.findElements(By.xpath("//div[@id='UserReportList_wrapper']/table/thead/tr/th"));
		for(int i=0; i<(HoldOrderGridheaders.size()-1);i++)
		{
			if(HoldOrderGridheaders.get(i).getText().contains("Order Doc No"))
			{
				System.out.println(HoldOrderGridheaders.get(i).getText());
				String colno =Integer.toString(i);		
				List<WebElement> DocumentNumbers = driver.findElements(By.xpath("//div[@id='UserReportList_wrapper']/table/tbody/tr/td["+colno+"]"));
				CashOrderPage cashO= new CashOrderPage(driver);
				String DocNo = cashO.docNo;
				for(WebElement DocumentNo : DocumentNumbers)
				{
					if(DocumentNo.getText().equalsIgnoreCase(DocNo))
						{
							System.out.println("Holded Order is displayed in Hold Order List Page with Order No " + DocNo);
						}
				}
//				boolean abc = DocumentNumbers.stream().anyMatch(DocumentNo->DocumentNo.getText().equalsIgnoreCase(DocNo));
//				softAssert.assertTrue(abc);
			}
		}
		
	}


}
