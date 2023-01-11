package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.DuplicateRetailerMergePage;
import PageObjects.SODashBoardPage;
import PageObjects.landingPage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateRetailersMerge extends BaseTest {
	
	WebDriver driver;
	
	@Test
	public void LoginasSO() throws IOException, InterruptedException
	{
		//initializeDriver();
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://leapqa.himalayawellness.com/IODP/Account/Login");
		driver.manage().window().maximize();
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("HI00015934", "*");
		
	}
	
	@Test
	public void OpenduplicateRetailerMergePage() throws InterruptedException
	{
		SODashBoardPage dashBoard = new SODashBoardPage(driver);
		dashBoard.verifyMasterMenuDisplay();
		dashBoard.duplicateRetailerMergemenudisplay();
		dashBoard.openDuplicateRetailersMergerPage();
		
	}
	
	
	@Test
	public void SearchuplicateRetailersList() throws InterruptedException
	{
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.verifyTeamandApprovalstatusdrodpwndispaly();
		duplicateRetailers.verifySearchandRefreshbuttondisplay();
		duplicateRetailers.searchDuplicateRetailers("All", "Un-Verified");
		
	}
	
	
	@Test
	public void duplicateRetailersListDisplay() throws InterruptedException
	{
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.verifyDuplicateRetailersListDisplay();
		
	}
	
	
	@Test
	public void searchUnVerifiedRetailers() throws InterruptedException
	{
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.verifyTeamandApprovalstatusdrodpwndispaly();
		duplicateRetailers.searchDuplicateRetailers("urban", "Select all");
		
	}
	
	
	@Test
	public void selectRetailertoEditasDuplicateRetailer() throws InterruptedException
	{
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.EditDuplicateRetailer();
		
	}
	
	
	@Test
	public void MergeDuplicateRetailer1() throws InterruptedException
	{
		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
		duplicateRetailers.EditDuplicateRetailer();
		duplicateRetailers.MergeRetailer1details();
		
	}
	
//	@Test
//	public void MergeDuplicateRetailer2() throws InterruptedException
//	{
//		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
//		duplicateRetailers.EditDuplicateRetailer();
//		duplicateRetailers.MergeRetailer2details();
//		
//	}
//	
//	@Test
//	public void MergeasNonDuplicateRetailers() throws InterruptedException
//	{
//		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
//		duplicateRetailers.EditDuplicateRetailer();
//		duplicateRetailers.declareRetailerasNonDuplicate();
//		
//	}
//	
//	@Test
//	public void MergeasChainRetailers() throws InterruptedException
//	{
//		DuplicateRetailerMergePage duplicateRetailers=new DuplicateRetailerMergePage(driver);
//		duplicateRetailers.EditDuplicateRetailer();
//		duplicateRetailers.declareRetailerasChainOutlet();
//		
//	}
	

}
