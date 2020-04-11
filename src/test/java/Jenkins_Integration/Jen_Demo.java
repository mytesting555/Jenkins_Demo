package Jenkins_Integration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Jen_Demo 
{
	static WebDriver driver;
  @Test
  public void f() 
  {
	  String pgtitle=driver.getTitle();
	  
	  System.out.println("The page title is: "+pgtitle);
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\windows7\\Desktop\\software\\Browser Drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		
		driver=new FirefoxDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch web site
		driver.get("https://demoqa.com/automation-practice-form/");
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
