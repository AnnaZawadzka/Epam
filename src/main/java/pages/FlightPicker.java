package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import helpers.WaitHelpers;

public class FlightPicker {

	private WebDriver driver;

	public FlightPicker(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(css = "#outbound flights-table-price:not(.show-mobile) .core-btn-primary")
	private List<WebElement> buttonsOutboundPrice;

	@FindBy(css = "#outbound .flights-table-fares__head")
	private List<WebElement> optionsOutbound;

	@FindBy(css = "#inbound flights-table-price:not(.show-mobile) .core-btn-primary")
	private List<WebElement> buttonsInboundPrice;

	@FindBy(css = "#inbound .flights-table-fares__head")
	private List<WebElement> optionsInbound;

	@FindBy(xpath = ".//*[@id='continue']")
	private WebElement buttonContinue;

	public void selectFlightOption() throws Throwable {
		WaitHelpers.visibilityOfAllElements(driver, buttonsOutboundPrice);
		this.buttonsOutboundPrice.get(0).click();
		WaitHelpers.visibilityOfAllElements(driver, optionsOutbound);
		this.optionsOutbound.get(0).click();
		WaitHelpers.staticWait(10);
		WaitHelpers.visibilityOfAllElements(driver, buttonsInboundPrice);
		this.buttonsInboundPrice.get(0).click();
		WaitHelpers.visibilityOfAllElements(driver, optionsInbound);
		this.optionsInbound.get(0).click();
	}

	public void continueClick() {
		WaitHelpers.waitForElementToBeClicable(driver, buttonContinue);
		this.buttonContinue.click();
	}

}
