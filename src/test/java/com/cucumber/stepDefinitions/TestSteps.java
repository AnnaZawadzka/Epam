package com.cucumber.stepDefinitions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.*;

import pages.FOH;
import pages.FlightPicker;

public class TestSteps {
	
	public static WebDriver driver;
	public FOH foh;
	public FlightPicker flightPicker;
	
	public TestSteps(TestContext context){
		driver = context.getDriver();
		foh = new FOH(driver);
		flightPicker = new FlightPicker(driver);
	}

	@Given("^I have a booking with any PAX$")
	public void i_have_a_booking_with_any_PAX() throws Throwable {

		foh.open();
		foh.pressTabLogIn();
		foh.logIn("azawatest1@gmail.com", "890iopjkL");
		foh.chooseFlight("Dublin", "London Stansted", "28", "31");
		
	}

	@Given("^I proceed to payment page$")
	public void i_proceed_to_payment_page() throws Throwable {
		
		flightPicker.selectFlightOption();
		flightPicker.continueClick();
		Thread.sleep(9999);
	   
		
	}
//
//	@When("^I pay for a flight using not existing card$")
//	public void i_pay_for_a_flight_using_not_existing_card() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//
//	}
//
//	@Then("^my payment is declined with validation message$")
//	public void my_payment_is_declined_with_validation_message() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions

//	}

}
