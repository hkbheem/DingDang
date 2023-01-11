package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponents {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Abstractcomponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void waitForAnElementToAppear(WebElement element1)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element1));
		
	}
	
	public void waitForInvisibilityofElement(WebElement element2)
	{
		
		wait.until(ExpectedConditions.invisibilityOf(element2));
	}
	
	public void waitForElementtobeClickable(WebElement element3)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element3));
		
	}


}
