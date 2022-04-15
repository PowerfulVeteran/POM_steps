package com.qa.temp.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public WebDriver inti_driver(Properties prop) {
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Running on Browser => " + browserName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			threadLocalDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver(optionsManager.getEdgeOptions());
			threadLocalDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			threadLocalDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else {
			System.out.println("Browser not found");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip =null;
		String env = System.getProperty("env"); //read env from command line
		
		System.out.println("Runing on Environment : --> PRODUCTION");
		if(env == null) {
			try {
				 ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				System.out.println("Runing on Environment : --> "+env.toUpperCase());
				switch (env) {
					case "qa":
						ip = new FileInputStream(".\\src\\test\\resources\\config\\qa.config.properties");
						break;
					case "dev":
						ip = new FileInputStream(".\\src\\test\\resources\\config\\dev.config.properties");
						break;
					case "stage":
						ip = new FileInputStream(".\\src\\test\\resources\\config\\stage.config.properties");
						break;
					default:
						break;			
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("File Not Found !");
				e.printStackTrace();				
			}
		}
		
		try {
			
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
	

	/**
	 * THIS METHOD WILL CAPTURE SCREEN SHOTS WITH THE HELP OF SELENIUM
	 * WHEH THE TESTS FAIL OR SKIPPED.
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}
