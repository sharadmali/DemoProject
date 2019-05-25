package XoriantDemo.XoriantDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public WebDriver driver;
	
	@Test
	public void launch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://www.airindia.in");
		WebElement elm = driver.findElement(By.xpath("//a[text()='Home']"));
		elm.click();
	}
	@Test
	public void add() {			
		
		System.out.println("---------Addition");
		int a = 20;
		int b = 20;		
		Assert.assertEquals(40, a+b);
	}
	
	@Test
	public void sub() {	
		
		System.out.println("---------Subtraction");
		int a = 10;
		int b = 20;
		Assert.assertEquals(10, b-a);
	}
		
	@Test
	public void mul() {	
		
		System.out.println("---------Multiplication");
		int a = 10;
		int b = 20;
		Assert.assertEquals(200, a*b);
	}
	
	@Test
	public void div() {
		
		System.out.println("---------Division");
		int a = 10;
		int b = 20;
		Assert.assertEquals(2, b/a);
	}		
}
