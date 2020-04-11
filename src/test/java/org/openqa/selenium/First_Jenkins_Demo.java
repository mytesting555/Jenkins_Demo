//package Jenkins_Integration;
package org.openqa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First_Jenkins_Demo {

	static WebDriver driver;
		// TODO Auto-generated method stub
	
	///method for highlight element
	public static void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ; border: 2px solid red;');",
				element);

		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}

	
	@BeforeTest
	public static void browserSetup()
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		
		driver=new FirefoxDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch web site
		driver.get("https://www.facebook.com");
	}
	@Test
	public static void test1() throws Exception
	{
		
		String fbtitle=driver.getTitle();
		
		System.out.println("facebook title is: "+fbtitle);
		
		
		WebElement firstname=driver.findElement(By.id("u_0_m"));
		
		highlightElement(driver, firstname);
		
		firstname.sendKeys("Thomas");
		
		Thread.sleep(2000);
		
		WebElement lastname=driver.findElement(By.id("u_0_o"));
		
		highlightElement(driver, lastname);
		
		lastname.sendKeys("D'caprio");
		
		Thread.sleep(2000);
		
		WebElement email=driver.findElement(By.id("u_0_r"));
		
		highlightElement(driver, email);
		
		email.sendKeys("thomas.test@gmail.com");
		
		WebElement pass=driver.findElement(By.id("u_0_w"));
		
		highlightElement(driver, pass);
		
		pass.sendKeys("thomas@123");
		
		Thread.sleep(2000);
		
		
		
		/*
		//enter first name and surname
		driver.findElement(By.name("firstname")).sendKeys("Ethan");
		//test.pass("Firstname entered");
		
		driver.findElement(By.id("lastname")).sendKeys("Hunt");
		
		*/
		Thread.sleep(3000);
	}
	@AfterMethod
	public static void closebrowser()
	{
		
		//close the browser
		driver.close();
		
	}
}
