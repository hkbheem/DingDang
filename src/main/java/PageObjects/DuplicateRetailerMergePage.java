package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import AbstractComponents.Abstractcomponents;

public class DuplicateRetailerMergePage extends Abstractcomponents{
	
	WebDriver driver;
	
	public DuplicateRetailerMergePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//h4[normalize-space()='Duplicate Retailer Merge']")
	WebElement pageHeader;
	
	@FindBy(xpath="//div[@class='panel-body serchbox-panel']")
	WebElement searchPanel;
	
	@FindBy(xpath="//div[@class='col-sm-2']/div/div/div/a")
	WebElement teamDropdown;
	
	@FindBy(xpath="//div[@class='btn-group']//button//span")
	WebElement approvalStatusDropdown;
	
	
	public void verifyTeamandApprovalstatusdrodpwndispaly() throws InterruptedException
	{
		searchPanel.click();
		waitForAnElementToAppear(teamDropdown);
		teamDropdown.isDisplayed();
		approvalStatusDropdown.isDisplayed();
		
	}
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement searchButton;
	
	@FindBy(xpath="//button[@class='btn btn-custom btn-refresh']")
	WebElement refreshButton;
	
	public void verifySearchandRefreshbuttondisplay()
	{
		searchButton.isDisplayed();
		refreshButton.isDisplayed();
	}
	
	@FindBy(xpath="//label[normalize-space()='Select all']")
	WebElement selectAllStatus;
	
	
	public void searchDuplicateRetailers(String Team, String Status) throws InterruptedException
	{
		teamDropdown.click();
		waitForAnElementToAppear(selectAllStatus);
		List<WebElement> teams = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
		for(WebElement team : teams)
		{
			if(team.getText().equalsIgnoreCase(Team))
			{
				team.click();
				break;
			}
		}
	
		approvalStatusDropdown.click();
		waitForAnElementToAppear(approvalStatusDropdown);
		List<WebElement> statuses = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a"));
		for(WebElement status : statuses)
		{
			if(status.getText().equalsIgnoreCase(Status))
			{
				status.click();
				break;
			}
		}
		
		waitForAnElementToAppear(searchButton);
		searchButton.click();
	}
	
	
	public void verifyDuplicateRetailersListDisplay()
	{
		List<WebElement> RetailerList=driver.findElements(By.xpath("//tbody/tr"));
		if(RetailerList.size()>0)
		{
			System.out.println("DuplicateRetailers List is Displayed" + RetailerList.size());
		}
	}


	public void EditDuplicateRetailer() throws InterruptedException
	{
		List<WebElement> actionicon=driver.findElements(By.xpath("//tbody/tr/td[1]/div[1]/a[1]"));
		
		for(WebElement editorview : actionicon)
		{
			if(editorview.getAttribute("class").equalsIgnoreCase("btn btn-sm Edit"))
			{
				waitForElementtobeClickable(editorview);
				
				editorview.click();
				
			}

		}
		
		
	}
	
	
	@FindBy(xpath="//table[@id='SapMessagePopUp']/tbody/tr[1]/td[3]")
	WebElement PrimaryRetailer1Select;
	
	@FindBy(xpath="//button[normalize-space()='Merge']")
	WebElement Merge;
	
	@FindBy(xpath="//div[@id='ConfirmDialog']//div[@class='modal-content']")
	WebElement ConfirmPopup;
	
	@FindBy(xpath="//button[@id='ConfirmOKbutton']")
	WebElement ConfirmOK;
	
	@FindBy(xpath="//div[@id='PromtDialog']")
	WebElement SuccessMessage;
	
	@FindBy(xpath="//div[@id='RetailerMergePopup']//div[@class='modal-content']")
	WebElement RetailerMergeDetailsPopup;
	
	public void MergeRetailer1details()
	{
		waitForAnElementToAppear(RetailerMergeDetailsPopup);
		RetailerMergeDetailsPopup.isDisplayed();
		PrimaryRetailer1Select.click();
		Merge.click();
		waitForAnElementToAppear(ConfirmPopup);
		ConfirmPopup.isDisplayed();
		ConfirmOK.click();
		waitForAnElementToAppear(SuccessMessage);
		SuccessMessage.isDisplayed();
			
	}
	
	@FindBy(xpath="//table[@id='SapMessagePopUp']/tbody/tr[1]/td[4]")
	WebElement PrimaryRetailer2Select;
	
	
	public void MergeRetailer2details()
	{
		waitForAnElementToAppear(RetailerMergeDetailsPopup);
		RetailerMergeDetailsPopup.isDisplayed();
		PrimaryRetailer2Select.click();
		Merge.click();
		waitForAnElementToAppear(ConfirmPopup);
		ConfirmPopup.isDisplayed();
		ConfirmOK.click();
		waitForAnElementToAppear(SuccessMessage);
		SuccessMessage.isDisplayed();
			
	}
	
	@FindBy(xpath="//button[normalize-space()='Chain Outlet']")
	WebElement ChainOutlet;
	
	public void declareRetailerasChainOutlet()
	{
		waitForAnElementToAppear(RetailerMergeDetailsPopup);
		RetailerMergeDetailsPopup.isDisplayed();
		ChainOutlet.click();
		waitForAnElementToAppear(ConfirmPopup);
		ConfirmPopup.isDisplayed();
		ConfirmOK.click();
		waitForAnElementToAppear(SuccessMessage);
		SuccessMessage.isDisplayed();
		
	}
	
	@FindBy(xpath="//button[normalize-space()='Non Duplicate']")
	WebElement NonDuplicate;
	
	public void declareRetailerasNonDuplicate()
	{
		waitForAnElementToAppear(RetailerMergeDetailsPopup);
		RetailerMergeDetailsPopup.isDisplayed();
		NonDuplicate.click();
		waitForAnElementToAppear(ConfirmPopup);
		ConfirmPopup.isDisplayed();
		ConfirmOK.click();
		waitForAnElementToAppear(SuccessMessage);
		SuccessMessage.isDisplayed();
		
	}
	
	
	
	
	
	

//	
//	@Test
//	public void chooseRetailertoMerge()
//	{
//		RetailerMergeDetailsPopup.isDisplayed();
//		List<WebElement> gridHeaders=driver.findElements(By.xpath("//table[@id='SapMessagePopUp']/thead/tr/th"));
//		for(int i=1;i<=gridHeaders.size();i++)
//		{
//			if(gridHeaders.get(i).getText().equalsIgnoreCase("Retailer1"))
//			{
//				String colno=Integer.toString(i);
//				List<WebElement> fieldnames=driver.findElements(By.xpath("//table[@id='SapMessagePopUp']/tbody/tr/td["+colno+"]"));
//				for(int j=1;j<=fieldnames.size();j++)
//				{
//					if(fieldnames.get(j).getText().equalsIgnoreCase("PinNo"))
//					{
//						String rowno=Integer.toString(j);
//						List<WebElement> PinNos=driver.findElements(By.xpath("//table[@id='SapMessagePopUp']/tbody/tr["+rowno+"]/td"));
//						for(int k=1;k<=PinNos.size();k++)
//						{
//							String Retailer1Pin=PinNos.get(k).getText();
//							
//							
//						}
//						
//						
//						
//					}
//					
//				}
//				
//				
//			}
//		}
//	}
	
	


}
