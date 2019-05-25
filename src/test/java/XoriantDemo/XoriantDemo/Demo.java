package XoriantDemo.XoriantDemo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public WebDriver driver;
	
	@Test
	public void launch() throws InterruptedException {
		
		WebDriver driver = null;
		
		//String browser = "chrome";
		String browser = "ie";
		
		switch (browser.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--always-authorize-plugins"));

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			options.addArguments("--no-sandbox");
			options.addArguments("start-maximized");
			//options.addArguments("--headless");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);	
			break;
			
		case "ie":
			//WebDriverManager.iedriver().setup();	
			
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			
			//caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);			
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new InternetExplorerDriver(caps);
			break;		
		}
		
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Guru99");
		element.submit();
		
		Thread.sleep(5000);
		JavascriptExecutor je = (JavascriptExecutor) driver;		
		WebElement elm = driver.findElement(By.xpath("//*[@id='gb_70']"));
		je.executeScript("arguments[0].scrollIntoView(true);",elm);
		
		elm.click();
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {			
			FileUtils.copyFile(src, new File("C:\\Temp\\error.png"));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
		
		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
		
	}
	
		
}
