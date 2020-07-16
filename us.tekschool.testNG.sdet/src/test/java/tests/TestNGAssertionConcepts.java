package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.Base;
import pageObj.HotelLoginPageObj;

public class TestNGAssertionConcepts extends Base {
	HotelLoginPageObj hotelpageObj;

	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}

	@Test
	public void assertionTest() {
		String title = driver.getTitle();
		// if i change the title from "Tek School Hotel Website" to "Hotel" then the
		// test case will run successfully
		String expectedTitle = "Tek School Hotel Website";

		// hard assertion
		Assert.assertEquals(title, expectedTitle);
		// hard assertion will stop the execution when it gets failed
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.enterEmail(Base.getUserName());
		hotelpageObj.enterPassword(Base.getPassword());
		hotelpageObj.clickonSignInButton();

	}

	@Test
	public void softAssertionConcept() {
		String title = driver.getTitle();
		String expectedTitle = "Tek School Hotel website";

		// soft assertion will keep the code running and tell after execution what was the exception
		// add soft Assertion
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, expectedTitle);
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clickonSignIn();
		hotelpageObj.enterEmail(Base.getUserName());
		hotelpageObj.enterPassword(Base.getPassword());
		hotelpageObj.clickonSignInButton();
		softAssert.assertAll();

	}

	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");
	}

}
