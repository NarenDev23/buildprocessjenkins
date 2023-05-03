package org.teststep;

import org.basestep.LearnBaseClass;
import org.pomstep.AdactinPomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TestStepClass extends LearnBaseClass {
	public AdactinPomClass pom;

	@Given("User should be in adactin home page")
	public void tc01() {
		browserLaunch("edge");
		launchUrl("https://adactinhotelapp.com/");
	}

	@When("User should enter the {string} and {string}")
	public void tc02(String user, String pass) {
		pom = new AdactinPomClass();
		pom.login(user, pass);

	}

	@When("User should click the login button and verify login message")
	public void tc03() {
		System.out.println("Login button clicked successfully");
	}

	@Given("User Should Hotel be in Search Page")
	public void tc04() {
		System.out.println("Search hotel Page Displayed ");
	}

	@When("User Enter the hotellocation {string},{string},{string},{string},{string},{string},{string},{string}")
	public void tc05(String location, String hoteln, String typeroom, String noofroom, String indate, String outdate,
			String adultno, String childno) {
		pom = new AdactinPomClass();
		pom.searchHotel(location, hoteln, typeroom, noofroom, indate, outdate, adultno, childno);
	}

	@When("User should click the search button and verify search message")
	public void tc06() {
		pom.searchOk();
		System.out.println("Hotel Searched ");
	}

	@Given("User Shuold be in Hotel Page")
	public void tc07() {
		System.out.println("Select Hotel Page Displayed");
	}

	@When("User Should select the Hotel and click continue")
	public void tc08() {
		pom = new AdactinPomClass();
		pom.selectHotel();
		System.out.println("Hotel Selected"); 
	}

	@Given("User Should be in Book a Hotel Page")
	public void tc10() {
		System.out.println("Hotel Page Displayed");
	}

	@When("User Enter Firstname {string},{string},{string},{string},{string},{string},{string},{string}")
	public void tc11(String fName, String lName, String ad, String ccnum, String ccType, String month,
			String year, String cvv) {
		pom = new AdactinPomClass();
		pom.hotelpage(fName, lName, ad, ccnum, ccType, month, year, cvv);
	}

	@When("User shoud click the BookNow button and verify booking")
	public void tc12() {
		pom.bookHotel();
		System.out.println("Hotel Booked");
	}

	@When("User Should get the OrderId")
	public void tc13() {
		pom.orderId();
		System.out.println();
	}

}
