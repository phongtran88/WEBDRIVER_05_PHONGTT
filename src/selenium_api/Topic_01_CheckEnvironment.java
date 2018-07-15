package selenium_api;

import org.testng.annotations.Test;

//import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Topic_01_CheckEnvironment {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println("Check homepage title");
	  String homePageTitle = driver.getTitle();
	  Assert.assertEquals(homePageTitle, "Guru99 Bank Home Page");
	  
	  System.out.println("Check homepage url");
	  String homePageUrl = driver.getCurrentUrl();
	  Assert.assertEquals(homePageUrl, "http://demo.guru99.com/v4/");
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  

}
