package com.qa.temp.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	private OptionsManager optionsManager;
	public static String highlight = "false";
	
	public WebDriver inti_driver (Properties prop) {
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Running on Browser:" +browserName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(optionsManager.getEdgeOptions());
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		}	
		else {
			System.out.println("Browser not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		
		return driver;
	}
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input or Output Exception");
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}
