package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AbstractComponents.Abstractcomponents;

public class landingPage extends Abstractcomponents{

	WebDriver driver;
	
	ExtentReports extent;
	
	DashBoard dashboard;
	
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#label1")
	WebElement UserName;
	
	@FindBy(css="#label")
	WebElement Passd;
	
	@FindBy(css="button[type='submit']")
	WebElement Submit;
	
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement AlerttoDist;
	
	@FindBy(xpath="(//button[@id='DocumentClose'])[1]")
	WebElement DocumentClose;
	
	@FindBy(css="div[id='DistPendingGRNPopup'] div[class='modal-content']")
	WebElement PendingGRNAlertPopup;
	
	@FindBy(xpath="//div[@id='DistPendingGRNPopup']//button[@id='FoodLicencePopupDocumentClose']")
	WebElement GRNAlertclose;
	
	

	By primaryOrder = By.xpath("//span[normalize-space()='Primary Order']");
	
	@Test
	public DashBoard LoginToApplication(String Username, String Password)
	{
		//extent.createTest(result.getMethod().getMethodName());
		UserName.sendKeys(Username);
		Passd.sendKeys(Password);
		Submit.click();
		if(AlerttoDist.isDisplayed())
		{
			DocumentClose.click();
		}
		
		else if(PendingGRNAlertPopup.isDisplayed())
		{
			GRNAlertclose.click();
			
		}
		return new DashBoard(driver);
			
	}
	
	@FindBy(xpath="//div[@id='alert-box']")
	WebElement erroralert;
	
	@Test
	public void verifyLoginforInvalidCreds(String Username, String Password)
	{
		UserName.sendKeys(Username);
		Passd.sendKeys(Password);
		Submit.click();
		String errormessage =erroralert.getText();
		SoftAssert as = new SoftAssert();
		as.assertEquals(errormessage, "Invalid User Name or Paswod");
		as.fail();
	
	}

}
