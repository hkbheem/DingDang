package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DynamicTableValidation {

	
	
	@Test
	public void HoldOrderList() throws InterruptedException
	{
		System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\executables");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leapqa.himalayawellness.com/IODP/Account/Login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='label1']")).sendKeys("700028");
		driver.findElement(By.xpath("//input[@id='label']")).sendKeys("*");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Sales Order Delivery']"))).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Cash Order']")).click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id("DDLTeam")));
		select.selectByVisibleText("SHH");
		Select S1 = new Select(driver.findElement(By.id("Cashorder_status")));
		S1.selectByVisibleText("Retailer Order");
		Thread.sleep(2000);
		Select S2 = new Select(driver.findElement(By.id("RetailerName")));
		S2.selectByVisibleText("79 SUPER MARKET");
		driver.findElement(By.xpath("//button[@id='createOrder']")).click();
		Thread.sleep(2000);
		Select s3 = new Select(driver.findElement(By.xpath("//select[@id='ProductList']")));
		s3.selectByVisibleText("[7001697] ALMOND and ROSE SOAP SOAP 75G");
		driver.findElement(By.xpath("//input[@id='OrderQty']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@id='AddProductButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='btn-group u-flex -w-100']//a[@id='HoldButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='ConfirmOKbutton']")).click();
		Thread.sleep(2000);
		String alertsuccess = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String[] DocNo = alertsuccess.split("");
		String DocumentNo=DocNo[0].toString();
		a1.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Sales Order Delivery']"))).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Hold Order List']")).click();
		Thread.sleep(2000);
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='UserReportList']/thead/tr/th"));
		for(int i=1;i<headers.size();i++)
		{
			String docNo= headers.get(i).getText();
			System.out.println(docNo);
			if(docNo.equals("Order Doc No"))
			{
				System.out.println(i);
				String columnno=Integer.toString(i);
				List<WebElement> OrderDocNo = driver.findElements(By.xpath("//table[@id='UserReportList']/tbody/tr/td["+columnno+"]"));
				for(WebElement orderNo: OrderDocNo)
				{
					if(orderNo.getText().equalsIgnoreCase(docNo))
					{
						System.out.println( docNo + "Hold Order Exist");

					}
				}
				
			}
			
		}
		
		
		
		
		
	}
}
