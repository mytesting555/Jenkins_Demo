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
