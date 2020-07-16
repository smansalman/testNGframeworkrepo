package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution extends Base {
	
	@Test
	public void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from Chrome Execution: " + driver.getTitle());
		
	}
	
	@Test
	public void fireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from Firefox Execution: " + driver.getTitle());
	}
	@Test
	public void internetExpBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from IE Execution: " + driver.getTitle());
	}

	

}
