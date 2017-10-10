package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PotentialTrip {

	private WebDriver driver;
	
	public PotentialTrip(WebDriver driver) {
		
		this.driver = driver;
		  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = ".//button[@data-ref='pt-page-btn-checkout']")
	private WebElement buttonCheckOut;
	
	@FindBy(xpath = ".//button[@class='core-btn-ghost seat-prompt-popup-footer-btn']")
	private WebElement buttonCloseSeatsPopup;
	
	public void checkOutClick() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(9999); //temporary
		wait.until(ExpectedConditions.elementToBeClickable(this.buttonCheckOut));
		this.buttonCheckOut.click();
		}


	public void closeSeatsPopupClick(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(this.buttonCloseSeatsPopup));
		this.buttonCloseSeatsPopup.click();
		
		}
	
}
