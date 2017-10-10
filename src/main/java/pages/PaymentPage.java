package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

private WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		
		this.driver = driver;
		  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(css = "[class='core-select'] [ng-model='passenger.name.title']")
	private WebElement selectTitle;
	
	@FindBy(xpath = ".//input[@ng-model='passenger.name.first']")
	private WebElement inputName;
	
	@FindBy(xpath = ".//input[@ng-model='passenger.name.last']")
	private WebElement inputSurname;
	
	@FindBy(xpath = ".//select[@name='phoneNumberCountry']")
	private WebElement selectPhoneCountry;
	
	@FindBy(xpath = ".//input[@ng-model='ctrl.model.number']")
	private WebElement inputPhoneNumber;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.cardModel.cardNumber']")
	private WebElement inputCardNumber;
	
	@FindBy(xpath = ".//select[@ng-model='$ctrl.cardModel.cardType']")
	private WebElement selectCardType;
	
	@FindBy(xpath = ".//select[@ng-model='$ctrl.cardModel.expiry.month']")
	private WebElement selectExpiryMonth;
	
	@FindBy(xpath = ".//select[@ng-model='$ctrl.cardModel.expiry.year']")
	private WebElement selectExpiryYear;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.cardModel.securityCode']")
	private WebElement inputCVV;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.cardModel.cardHolderName']")
	private WebElement inputCardHolder;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.model.addressLine1']")
	private WebElement inputAdress;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.model.city']")
	private WebElement inputCity;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.model.postcode']")
	private WebElement inputPostcode;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.termsAccepted']")
	private WebElement inputAcceptConditions;
	
	@FindBy(xpath = ".//button[@class='core-btn-primary core-btn-medium']")
	private WebElement buttonPayNow;
	
	@FindBy(xpath = ".//div[@translate='common.components.payment_forms.error_explain_declined']")
	private WebElement vaildationPayment;
	
	
public void fillPassengerData(String name, String surname) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(selectTitle));
		Select dropdown = new Select(selectTitle);
		dropdown.selectByIndex(1);
		this.inputName.click();
		this.inputName.sendKeys(name);
		this.inputSurname.click();
		this.inputSurname.sendKeys(surname);
		Thread.sleep(9999);
		
		}

public void paymentDetails(String number, String cardNumber,String cvv, String holderName ) throws Throwable {
	
	Select dropdown = new Select(selectPhoneCountry);
	dropdown.selectByIndex(3);
	this.inputPhoneNumber.click();
	this.inputPhoneNumber.sendKeys(number);
	this.inputCardNumber.click();
	this.inputCardNumber.sendKeys(cardNumber);
	Select dropdown1 = new Select(selectCardType);
	dropdown1.selectByIndex(2);
	Select dropdown2 = new Select(selectExpiryMonth);
	dropdown2.selectByIndex(5);
	Select dropdown3 = new Select(selectExpiryYear);
	dropdown3.selectByIndex(4);
	this.inputCVV.click();
	this.inputCVV.sendKeys(cvv);
	this.inputCardHolder.click();
	this.inputCardHolder.sendKeys(holderName);
	
		}

public void bilingAdress(String adress, String city, String postcode) throws Throwable {
	this.inputAdress.click();
	this.inputAdress.sendKeys(adress);
	this.inputCity.click();
	this.inputCity.sendKeys(city);
	this.inputPostcode.click();
	this.inputPostcode.sendKeys(postcode);
		}

public void acceptConditions() throws Throwable {
	this.inputAcceptConditions.click();
	this.buttonPayNow.click();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(buttonPayNow));
	
}

public WebElement checkValidation ()
{
	return vaildationPayment;
}


}