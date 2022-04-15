package commons;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected Log log;
	
	protected BaseTest() {
		
		log = LogFactory.getLog(getClass());
	
	}
	
	protected int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
	protected void quitBrowser(WebDriver d) {
		d.quit();
	}
	
	protected WebDriver getBrowserDriver(String browserStr) {
		String driverPath = "";
		WebDriver result = null;
		ChromeOptions options = new ChromeOptions();
		switch(browserStr) {
			case "chrome":
				System.out.println("Run on Chrome");
				//driverPath = userdir + "/browserDrivers/chromedriver96";
				//System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriverManager.chromedriver().setup();
				result = new ChromeDriver();
				break;
			case "firefox":
				System.out.println("Run on Firefox");
				//driverPath = userdir + "/browserDrivers/geckodriver";
				//System.setProperty("webdriver.gecko.driver", driverPath);
				WebDriverManager.firefoxdriver().setup();
				result = new FirefoxDriver();
				break;
			case "edge":
				System.out.println("Run on Edge");
				//driverPath = userdir + "/browserDrivers/msedgedriver";
				//System.setProperty("webdriver.edge.driver", driverPath);
				WebDriverManager.edgedriver().setup();
				result = new EdgeDriver();
				break;
			case "safari":
				result = new SafariDriver();
				break;	
			case "brave":
				//KO CHAY DUOC
				driverPath = GlobalContants.PROJECT_PATH + "/browserDrivers/chromedriver91";
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.setBinary("/Applications/Brave.app");
				result = new ChromeDriver(options);
				break;
			case "coccoc":
				//KO CHAY DUOC
				System.out.println("Run on Coccoc");
				driverPath = GlobalContants.PROJECT_PATH + "/browserDrivers/chromedriver94";
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
				options.setHeadless(true);
				result = new ChromeDriver(options);
				break;
			case "headless_firefox":
				System.out.println("Run on headless_firefox");
				//driverPath = userdir + "/browserDrivers/geckodriver";
				//System.setProperty("webdriver.gecko.driver", driverPath);
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions ffOption = new FirefoxOptions();
				ffOption.setHeadless(true);
				result = new FirefoxDriver(ffOption);
				break;
		}
		result.manage().window().maximize();
		result.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		result.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return result;
	}
	
	@AfterSuite(enabled=true, alwaysRun=true)
	protected void deleteAllBrowserDriverThreads() {
		System.out.println("-------- execute @AfterSuite");
		String osName = System.getProperty("os.name");
		System.out.println("OS NAME IS " + osName);
		if(osName.toLowerCase().startsWith("mac")) {
			try {
				Runtime.getRuntime().exec("pkill chromedriver");
				System.out.println("after execute 'pkill chromedriver' on mac os.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
