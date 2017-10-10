package com.cucumber.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.*;

import pages.FOH;
import pages.FlightPicker;
import pages.PotentialTrip;
import pages.PaymentPage;

public class TestSteps {

	private static WebDriver driver;
	private FOH foh;
	private FlightPicker flightPicker;
	private PotentialTrip potentialTrip;
	private PaymentPage paymentPage;

	public TestSteps(TestContext context) {

		driver = context.getDriver();
		foh = new FOH(driver);
		flightPicker = new FlightPicker(driver);
		potentialTrip = new PotentialTrip(driver);
		paymentPage = new PaymentPage(driver);
	}

	@Given("^I have a booking with any PAX$")
	public void i_have_a_booking_with_any_PAX() throws Throwable {
		foh.open();
		foh.pressTabLogIn();
		foh.logIn("azawatest1@interia.pl", "890iopjkL");
		foh.chooseFlight("Dublin", "London Stansted", "18", "25");
		foh.goToFlightPicker();

	}

	@Given("^I proceed to payment page$")
	public void i_proceed_to_payment_page() throws Throwable {
		flightPicker.selectFlightOption();
		flightPicker.continueClick();
		potentialTrip.checkOutClick();
		potentialTrip.closeSeatsPopupClick();

	}

	@When("^I pay for a flight using not existing card$")
	public void i_pay_for_a_flight_using_not_existing_card() {
		paymentPage.fillPassengerData("Anna", "Zawadzka");
		paymentPage.paymentDetails("1231231233", "5555555555555557", "235", "Jan Jan");
		paymentPage.bilingAdress("test1", "cityTest", "123963");
		paymentPage.acceptConditions();
	}

	@Then("^my payment is declined with validation message$")
	public void my_payment_is_declined_with_validation_message() {
		Assert.assertEquals(paymentPage.checkValidation(), true);

	}

}
