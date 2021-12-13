package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected String generateRandomNumber() {
		Random rand = new Random();
		int randomInt = rand.nextInt(1000);
		return "test" + randomInt + "@gmail.com";
	}
	
	protected WebDriver getBrowserDriver(String browserStr) {
		String userdir = System.getProperty("user.dir");
		String driverPath = "";
		WebDriver result = null;
		ChromeOptions options = new ChromeOptions();
		switch(browserStr) {
			case "chrome":
				System.out.println("Run on Chrome");
				//driverPath = userdir + "/browserDrivers/chromedriver96";
				//System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriverManager.chromedriver().setup();
				System.out.println("getDownloadedDriverPath: " + WebDriverManager.chromedriver().getDownloadedDriverPath());
				System.out.println("getDownloadedDriverVersion: " + WebDriverManager.chromedriver().getDownloadedDriverVersion());
				result = new ChromeDriver();
				break;
			case "firefox":
				System.out.println("Run on Firefox");
				//driverPath = userdir + "/browserDrivers/geckodriver";
				//System.setProperty("webdriver.gecko.driver", driverPath);
				WebDriverManager.firefoxdriver().setup();
				System.out.println("getDownloadedDriverPath: " + WebDriverManager.firefoxdriver().getDownloadedDriverPath());
				System.out.println("getDownloadedDriverVersion: " + WebDriverManager.firefoxdriver().getDownloadedDriverVersion());
				result = new FirefoxDriver();
				break;
			case "edge":
				System.out.println("Run on Edge");
				//driverPath = userdir + "/browserDrivers/msedgedriver";
				//System.setProperty("webdriver.edge.driver", driverPath);
				WebDriverManager.edgedriver().setup();
				System.out.println("getDownloadedDriverPath: " + WebDriverManager.edgedriver().getDownloadedDriverPath());
				System.out.println("getDownloadedDriverVersion: " + WebDriverManager.edgedriver().getDownloadedDriverVersion());
				result = new EdgeDriver();
				break;
			case "safari":
				result = new SafariDriver();
				break;	
			case "brave":
				//KO CHAY DUOC
				driverPath = userdir + "/browserDrivers/chromedriver91";
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.setBinary("/Applications/Brave.app");
				result = new ChromeDriver(options);
				break;
			case "coccoc":
				//KO CHAY DUOC
				System.out.println("Run on Coccoc");
				driverPath = userdir + "/browserDrivers/chromedriver94";
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.setBinary("/Applications/coccoc.app");
				System.out.println("set binary OK");
				result = new ChromeDriver(options);
				break;
			case "headless_chrome":
				System.out.println("Run on headless_chrome");
				//driverPath = userdir + "/browserDrivers/chromedriver95";
				//System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriverManager.chromedriver().setup();
				System.out.println("getDownloadedDriverPath: " + WebDriverManager.chromedriver().getDownloadedDriverPath());
				System.out.println("getDownloadedDriverVersion: " + WebDriverManager.chromedriver().getDownloadedDriverVersion());
				options.setHeadless(true);
				result = new ChromeDriver(options);
				break;
			case "headless_firefox":
				System.out.println("Run on headless_firefox");
				//driverPath = userdir + "/browserDrivers/geckodriver";
				//System.setProperty("webdriver.gecko.driver", driverPath);
				WebDriverManager.firefoxdriver().setup();
				System.out.println("getDownloadedDriverPath: " + WebDriverManager.firefoxdriver().getDownloadedDriverPath());
				System.out.println("getDownloadedDriverVersion: " + WebDriverManager.firefoxdriver().getDownloadedDriverVersion());
				FirefoxOptions ffOption = new FirefoxOptions();
				ffOption.setHeadless(true);
				result = new FirefoxDriver(ffOption);
				break;
		}
		return result;
	}

}
