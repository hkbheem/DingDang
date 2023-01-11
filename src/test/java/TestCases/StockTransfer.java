package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CashOrderPage;
import PageObjects.DashBoard;
import PageObjects.HoldOrderPage;
import PageObjects.InvoicePrintPage;
import PageObjects.StockTransferPage;
import PageObjects.landingPage;
import TestComponents.BaseTest;


public class StockTransfer extends BaseTest{
	
	
	String ToDistributor = "703343";
	String Qty = "5";
	
	@Test
	public void addStockTransfer() throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub		
		
		initializeDriver();
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("700028", "*");
		
		DashBoard dashboard = new DashBoard(driver);		
		dashboard.stockTransfer();
		
		StockTransferPage stocktransfer = new StockTransferPage(driver);
		stocktransfer.createStockTransfer(ToDistributor, Qty);
			
	}
	
	@Test(dependsOnMethods="addStockTransfer")
	public void SOApprovalStockTransfer() throws IOException 
	{
		initializeDriver();
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("700028", "*");
		
		DashBoard dashboard = new DashBoard(driver);		
		dashboard.stockTransfer();
		
		
	}
	
	
}
