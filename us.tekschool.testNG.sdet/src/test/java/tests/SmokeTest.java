package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.Base;
import pageObj.CreateAccountPageObj;
import pageObj.HotelLoginPageObj;

import utilities.ExcelUtility;

public class SmokeTest extends Base{
	HotelLoginPageObj hotelpageObj;
	CreateAccountPageObj createAccountPageObj;
	
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}
	
	@Test(dataProvider="getInfoData")
	public void createAccount(String email, String title, String firstname, String lastname, String password,
			String day, String month, String year) {
		hotelpageObj = new HotelLoginPageObj();
		createAccountPageObj = new CreateAccountPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("user clicked on sign in");
		
		createAccountPageObj.enterCreateEmail(email);
		logger.info("User entered: " + email);
		
		createAccountPageObj.clickOnCreateAnAccount();
		logger.info("User clicked on Create Account");
		
		createAccountPageObj.selectTitle(title);
		logger.info("User selected Title: " + title);
	
		createAccountPageObj.fillPersonalInformation(firstname, lastname, password, email);
		logger.info("User filled personal information");
		createAccountPageObj.dateOFBirthInfo(day.substring(0, 1), month.substring(0, 1), year.substring(0, 4));
		logger.info("User filled DOB information ");
		createAccountPageObj.registerAccount();
		logger.info("User clicked on Register Account");
		
	}
	
	@DataProvider()
	public Object [][] getInfoData(){
		Object data [][] = ExcelUtility.getExcelData("info");
		return data;
		
	}
	
	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");

	}
	
	

}
