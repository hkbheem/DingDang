package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v105.browser.Browser;
import org.testng.annotations.Test;

import PageObjects.DuplicateRetailerMergePage;
import PageObjects.SODashBoardPage;
import PageObjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Editclickaction {
	
	@Test
	public void EditDuplicateRetailer() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://leapqa.himalayawellness.com/IODP/Account/Login");
		driver.manage().window().maximize();
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("HI00015934", "*");
		
		SODashBoardPage dashBoard = new SODashBoardPage(driver);
		dashBoard.verifyMasterMenuDisplay();
		dashBoard.duplicateRetailerMergemenudisplay();
		dashBoard.openDuplicateRetailersMergerPage();
		
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.verifyTeamandApprovalstatusdrodpwndispaly();
		duplicateRetailers.searchDuplicateRetailers("All", "Select all");
		
		List<WebElement> actionicon=driver.findElements(By.xpath("//tbody/tr/td[1]/div[1]/a[1]"));
		
		for(WebElement editorview : actionicon)
		{
			if(editorview.getAttribute("class").equalsIgnoreCase("btn btn-sm Edit"))
			{
				
				Thread.sleep(4000);
				editorview.click();
				
			}

		}
		
		
	}


}
