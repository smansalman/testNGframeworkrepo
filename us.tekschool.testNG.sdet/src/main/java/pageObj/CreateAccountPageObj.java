package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class CreateAccountPageObj extends Base {

	public void CreateAcountPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='email_create']")
	private WebElement createEmailAddress;

	@FindBy(how = How.XPATH, using = "//form[@id='create-account_form']//span[1]")
	private WebElement createAnAccount;

	@FindBy(how = How.XPATH, using = "//input[@id='id_gender2']")
	private WebElement mrsTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']")
	private WebElement mrTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//select[@id='days']")
	private WebElement days;

	@FindBy(how = How.XPATH, using = "//select[@id='months']")
	private WebElement month;

	@FindBy(how = How.XPATH, using = "//select[@id='years']")
	private WebElement year;

	@FindBy(how = How.XPATH, using = "//input[@id='newsletter']")
	private WebElement signUpforNews;

	@FindBy(how = How.XPATH, using = "//input[@id='optin']")
	private WebElement receiveSpecialOffers;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]")
	private WebElement registerButton;

	public void enterCreateEmail(String email) {
		createEmailAddress.sendKeys(email);
	}

	public void clickOnCreateAnAccount() {
		createAnAccount.click();
	}

	public void selectTitle(String title) {
		if (title.equalsIgnoreCase("mr")) {
			mrTitle.click();
		} else
			mrsTitle.click();
	}

	public void fillPersonalInformation(String fName, String lname, String pass, String emailValue) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lname);
		DriverUtility.clearText(email);
		email.sendKeys(emailValue);
		password.sendKeys(pass);
	}

	public void dateOFBirthInfo(String dayValue, String monthValue, String yearValue) {
		DriverUtility.selectByValue(days, dayValue);
		DriverUtility.selectByValue(month, monthValue);
		DriverUtility.selectByValue(year, yearValue);
	}

	public void registerAccount() {
		signUpforNews.click();
		receiveSpecialOffers.click();
		registerButton.click();

	}
	
	public boolean createEmailAddressIsDisplayed() {
		boolean emailPresent = DriverUtility.isElementDisplayed(createEmailAddress);
		return emailPresent;
		
	}
	
	
}
