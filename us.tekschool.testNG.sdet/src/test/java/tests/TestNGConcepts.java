package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGConcepts {
	
	
	
	//There are three ways to send values to test cases in TestNG:
	//1.	Using Properties file
	//2.	Using Parameters 
		//a.	Store values in Testng.xml file
	//3.	Using Data Providers 
		//a.	From Excel 
	
	//We can prioritize our test cases using (Priority = number) 
	//We can Skip or not execute a test case using (enabled = false) or
	 //using @Ignore annotation. 
	
	//@Test(groups = {"smokeTest"})
	//@Test = TestNG annotation which indicates one test case
	//Groups=  When we wanna run multiple test cases part of one group or 
	//Test suite we can group them.
	
	//{SmokeTest} = name of groups and can be any value, smoke, regression 
	//Or any proper name company use to group its test cases.
	
	//TestNG-Failed.xml : anytime Tests fails TestNG will generate a xml file 
	//With failed test cases so you can re-run them from that file. if i wanna see the failed xml file
	// i have to go to test-output folder and then i have to go testng-failed.xml file
	
	// if the assertion passed then it will run the test case which is dependent upon assertion
	// it will successful only, if the assertion passed
	// here i just ignore all the tests using two methods which are ignore and enabled = false
	@Test
	@Ignore
	public void signIn() {
		String a = "school";
		String b = "college";
		Assert.assertEquals(a,b);
		
	}
	
	// this test case is dependent upon the assertion
	@Test(dependsOnMethods = {"signIn"}, enabled=false)
	public void homePage() {
		System.out.println("this test is dependent on signin test case");
		
	}
	
	// here assertion got passed so it will execute the dependent test case successfully
	@Test(enabled=false)
	public void signOut() {
		String a = "school";
		String b = "school";
		Assert.assertEquals(a,b);
		
	}
	
	@Test(dependsOnMethods = {"signOut"}, enabled=false)
	public void homePageLogout() {
		System.out.println("this test is dependent on signout test case");
	
	}
	
	@Test(invocationCount=3)
	public void checkTitle() {
		System.out.println("this will run 3 times");
	}
	@Test(groups = {"smokeTest"})
	public void logout() {
		System.out.println("log out test case");
	}
	@Test(groups = {"smokeTest"})
	public void dashborad() {
		System.out.println("dashboard test");
		
	}
	
	@Test(groups = {"smokeTest"})
	public void customerPage() {
		System.out.println("customer page test");
	}
}
