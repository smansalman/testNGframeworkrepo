package core;

import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	
	private String Propertypath =".\\src\\test\\resources\\properties\\ProjectProperty.properties";


	public Base() {
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(Propertypath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger = logger.getLogger("Logger_file");
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
	}
	

	// get browser method
	public static String getBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;
	}

	// get url method
	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	// get pageload method
	public static long getPageLoadTime() {
		String pageLoadTime = properties.getProperty("pageloadtime");
		return Long.parseLong(pageLoadTime);
	}

	// get implicit wait method
	public static long getImplicitWait() {
		String implicitWait = properties.getProperty("implicitwait");
		return Long.parseLong(implicitWait);
	}

	public static String getUserName() {
		String userName = properties.getProperty("userName");
		return userName;
	}

	public static String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

	public static void initializeDriver() {
		if (Base.getBrowserName().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Base.getBrowserName().equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (Base.getBrowserName().equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Base.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Base.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(Base.getURL());

	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
