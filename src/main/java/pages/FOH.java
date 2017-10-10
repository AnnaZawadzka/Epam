package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FOH {

	private WebDriver driver;
	private static final String HOME_PAGE_URL = "https://www.ryanair.com/gb/en/";
	
	private final String popupLogged = ".//*[@class='header-toaster__msg']"; 
		
	@FindBy(xpath = "//*[@id='myryanair-auth-login']")
	private WebElement tabLogIn;
	
	@FindBy(xpath = ".//input[@name='emailAddress']")
	private WebElement inputEmail;
	
	@FindBy(xpath = ".//input[@ng-model='$ctrl.password']")
	private WebElement inputPassword;
	
	@FindBy(xpath = ".//button[@class='core-btn-primary']/span[2]")
	private WebElement buttonLogIn;
	
	@FindBy(xpath = ".//input[@placeholder='Departure airport']") 
	private WebElement inputOutbound;
	
	@FindBy(xpath = ".//input[@placeholder='Destination airport']") 
	private WebElement inputInbound;
	
	@FindBy(xpath = ".//div[@class='core-list-item core-list-item-rounded initial']/span") 
	private WebElement firstElement;
	
	@FindBy(xpath = ".//input[@aria-label='Fly out: - DD']") 
	private WebElement inputFlyOut;
	
	@FindBy(xpath = ".//input[@aria-label='Fly back: - DD']") 
	private WebElement inputFlyBack;
	
	@FindBy(xpath = ".//button[@ng-click='searchFlights()']/span") 
	private WebElement buttonLetsGo;
	
	public FOH(WebDriver driver) {
		
		this.driver = driver;
		  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void open () {
		
		driver.get(HOME_PAGE_URL);	
	}
	
	public void pressTabLogIn () {
		
		this.tabLogIn.click();
	}
	
	public void logIn (String email, String password) {
		
		this.inputEmail.click();
		this.inputEmail.sendKeys(email);
	    this.inputPassword.click();
		this.inputPassword.sendKeys(password);
		this.buttonLogIn.click();		
	}
	
	public void chooseFlight (String outbound, String inbound, String outDate, String backDate) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupLogged)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(popupLogged)));
		this.inputOutbound.click();
		this.inputOutbound.sendKeys(outbound);
		this.inputInbound.click();
		this.inputInbound.sendKeys(inbound);
		this.firstElement.click();
		this.inputFlyOut.click();
		this.inputFlyOut.sendKeys(outDate);
		this.inputFlyBack.click();
		this.inputFlyBack.sendKeys(backDate);
		
	}
	
	public void goToFlightPicker() {
		
		this.buttonLetsGo.click();
	}
}
