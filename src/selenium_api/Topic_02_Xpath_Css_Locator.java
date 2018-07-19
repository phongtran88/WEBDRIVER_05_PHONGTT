package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Topic_02_Xpath_Css_Locator {
	WebDriver driver;
  @Test
  public void f() {
	  //ID
	  //Class
	  //Name
	  //Linktext
	  //Partial linktext
	  //tagname
	  //Xpath
	  //Css selector
  }
  
  @Test
  public void TC_01_VerifyURL_Title() throws InterruptedException {
	  driver = new FirefoxDriver();
	  driver.get("http://live.guru99.com");
	  Assert.assertEquals(driver.getTitle(), "Home page");
	  
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='login-form']/div/div[1]/div[2]/a")).click();
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
