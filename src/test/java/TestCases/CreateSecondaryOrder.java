package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CashOrderPage;
import PageObjects.DashBoard;
import PageObjects.HoldOrderPage;
import PageObjects.InvoicePrintPage;
import PageObjects.landingPage;
import TestComponents.BaseTest;


public class CreateSecondaryOrder extends BaseTest{
	
	@Test
	public void createSecondaryOrder() throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub		
		
		initializeDriver();
		landingPage landPage = new landingPage(driver);
		landPage.LoginToApplication("716854", "*");
		
		DashBoard dashboard = new DashBoard(driver);		
		dashboard.SecondaryOrder();
		
		CashOrderPage cashorder = new CashOrderPage(driver);
		//cashorder.CreateSalesOrder(, );
		cashorder.addDivisionTeamdetails();
		cashorder.addRetailerDetails("A.K.TRADERS");
		cashorder.addProductstoGrid("[7000543] ANTI WRINKLE CREAM 50g (NP 2003)","1");
		cashorder.verifyAddedProductDisplay();
		cashorder.previewInvoiceDetails();
		cashorder.saveOrder();
		cashorder.confirmDelivery();
		
		
	}
	
	@Test(dependsOnMethods="createSecondaryOrder")
	public void invoicePrintGST()
	{
		DashBoard dashboard = new DashBoard(driver);
		dashboard.invoicePrintGST();
		
		InvoicePrintPage invoiceprint = new InvoicePrintPage(driver);
		invoiceprint.verifyRecordDisplayInInvoicePrint();
		
	}
	
	@Test(priority=1)
	public void holdtheOrder() throws InterruptedException
	{
		DashBoard dashboard = new DashBoard(driver);
		dashboard.SecondaryOrder();
		
		CashOrderPage CO=new CashOrderPage(driver);
		CO.addDivisionTeamdetails();
		CO.addRetailerDetails("A.K.TRADERS");
		CO.addProductstoGrid("[7000543] ANTI WRINKLE CREAM 50g (NP 2003)","1");
		CO.previewInvoiceDetails();
		CO.holdOrder();
		
		dashboard.openHoldOrderList();
		HoldOrderPage holded=new HoldOrderPage(driver);
		holded.holdOrders();
		
	}

}
