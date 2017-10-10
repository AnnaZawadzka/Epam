package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import helpers.WaitHelpers;

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

	public void checkOutClick() throws Throwable {
		WaitHelpers.staticWait(10);
		WaitHelpers.waitForElementToBeClicable(driver, buttonCheckOut);
		this.buttonCheckOut.click();
	}

	public void closeSeatsPopupClick() {
		try {
			WaitHelpers.visibilityOf(driver, buttonCloseSeatsPopup);
			this.buttonCloseSeatsPopup.click();
		}

		catch (NoSuchElementException e) {
			System.out.println("Element Not Found");
		}
	}

}
