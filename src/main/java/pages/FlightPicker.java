package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPicker {
	
	private WebDriver driver;
	
	public FlightPicker(WebDriver driver) {
		this.driver = driver;
		  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
		  
			@FindBy(xpath = ".//flight-list[@id='outbound']//div[@class='ranimate-flights-table flights-table__flight first']//div[@class='flight-header__min-price hide-mobile']//div[@class='core-btn-primary' ]")
			private WebElement buttonOutboundPrice;
			
			//xPath refactoring
			//@FindBy(xpath = ".//*[@id='outbound']/form/div[3]/div/flights-table/div/div[1]/div/div/flights-table-fares/div/div[1]/div[1]/div[5]/div/flights-table-price/div/div/span[2]")
			//private WebElement optionOutboundStandard;
			
			@FindBy(css = "#outbound .flights-table-fares__head")
			private List<WebElement> optionsOutbound;
	
			@FindBy(xpath = ".//flight-list[@id='inbound']//div[@class='ranimate-flights-table flights-table__flight first']//flights-table-header[1]//div[@class='flight-header__min-price hide-mobile']//div[@class='core-btn-primary']")
			private WebElement buttonInboundPrice;
			
			//xPath refactoring
			@FindBy(xpath = ".//*[@id='inbound']/form/div[3]/div/flights-table/div/div[1]/div[1]/div/flights-table-fares/div/div[1]/div[1]/div[5]/div/flights-table-price/div/div/span[2]")
			private WebElement optionInboundStandard;
			
			@FindBy(xpath = ".//*[@id='continue']")
			private WebElement buttonContinue;
			
			@FindBy(css = "#inbound flights-table-price:not(.show-mobile) .core-btn-primary")
			private List<WebElement> ListBuutons;
			
			
			public void selectFlightOption () throws Throwable {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(buttonOutboundPrice));
				this.buttonOutboundPrice.click();
				wait.until(ExpectedConditions.visibilityOfAllElements(this.optionsOutbound));
				this.optionsOutbound.get(0).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='outbound']/form/div[3]/div/flights-table/div/div[1]/div/div/flights-table-fares/div/div[1]/div[1]/div[5]/div/flights-table-price/div/div/span[2]")));
				//this.optionOutboundStandard.click();
				//Thread.sleep(99999);
				wait.until(ExpectedConditions.visibilityOfAllElements(this.ListBuutons));
				this.ListBuutons.get(0).click();
			
				//this.buttonInboundPrice.click();
				//xPath refactorig
				wait.until(ExpectedConditions.visibilityOf(this.optionInboundStandard));
				this.optionInboundStandard.click();

			}
			
			public void continueClick(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(this.buttonContinue));
			this.buttonContinue.click();
			}
		  
	}
	


