package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Topic_04_Dropdown_Textbox {
	WebDriver driver;
	String CustomerID, name, dob, address, city, state, pin, mobile, email, pass, newAddress, newCity ;
	By nameTextBox = By.xpath("//input[@name='name']");
	By genderTextBox = By.xpath("//input[@name='gender']");
	By dobTextBox = By.xpath("//input[@name='dob']");
	By addressTextArea = By.xpath("//textarea[@name='addr']");
	By stateTextBox = By.xpath("//input[@name='state']");
	By cityTextBox = By.xpath("//input[@name='city']");
	By pinTextBox = By.xpath("//input[@name='pinno']");
	By mobileTextBox = By.xpath("//input[@name='telephoneno']");
	By emailTextBox = By.xpath("//input[@name='emailid']");
	By passTextBox = By.xpath("//input[@name='password']");
	
	
	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver( );
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  name = "fongtran";
		  dob = "1988-12-12";
		  address = "123 abcdef";
		  city = "sai gon";
		  state = "vinhloc";
		  pin = "123456";
		  mobile = "1234567";
		  email = "auto" + randomEmail() + "@gmail.com" ;
		  pass = "123456";
		  newAddress = "new add";
		  newCity = "ho chi minh";
	  }


  public void TC_01_DropDownList() {
	  
	  driver.get("http://daominhdam.890m.com/");
	  Select JobRole = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
	  Assert.assertTrue(!JobRole.isMultiple());
	  
	  JobRole.selectByVisibleText("Automation Tester");
	  Assert.assertEquals(JobRole.getFirstSelectedOption().getText(), "Automation Tester");
	  
	  JobRole.selectByValue("manual");
	  Assert.assertEquals(JobRole.getFirstSelectedOption().getText(), "Manual Tester");
	  
	  JobRole.selectByIndex(3);
	  Assert.assertEquals(JobRole.getFirstSelectedOption().getText(), "Mobile Tester");
	  
	  int JobItems = JobRole.getOptions().size();
	  Assert.assertEquals(JobItems, 5);
  }

  @Test
  public void TC_02_CustomDropDown() {
	  
	  driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	  driver.findElement(By.xpath("//span[@id='number-button']")).click();
	  
  }

  public void TC_03_TextBox_TextArea() {
	  
	  driver.get("http://demo.guru99.com/v4");
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr145519");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jynujUb");
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  String marquee = driver.findElement(By.xpath("//marquee")).getText();
	  Assert.assertEquals(marquee, "Welcome To Manager's Page of Guru99 Bank");

	  driver.findElement(By.xpath("//a[text()='New Customer']")).click();

	  driver.findElement(nameTextBox).sendKeys(name);
	  driver.findElement(dobTextBox).sendKeys(dob);
	  driver.findElement(addressTextArea).sendKeys(address);
	  driver.findElement(cityTextBox).sendKeys(city);
	  driver.findElement(stateTextBox).sendKeys(state);
	  driver.findElement(pinTextBox).sendKeys(pin);
	  driver.findElement(mobileTextBox).sendKeys(mobile);
	  driver.findElement(emailTextBox).sendKeys(email);
	  driver.findElement(passTextBox).sendKeys(pass);
	  driver.findElement(By.xpath("//input[@name='sub']")).click();

	  CustomerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	  
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), mobile);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
	  

	  driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
	  driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

	  Assert.assertTrue(driver.findElement(nameTextBox).isDisplayed());
	  Assert.assertTrue(driver.findElement(genderTextBox).isDisplayed());
	  Assert.assertTrue(driver.findElement(dobTextBox).isDisplayed());
	  Assert.assertTrue(driver.findElement(addressTextArea).isEnabled());
	  Assert.assertEquals(driver.findElement(nameTextBox).getAttribute("value"), name);
	  Assert.assertEquals(driver.findElement(addressTextArea).getText(), address);
	  
	  driver.findElement(addressTextArea).clear();;
	  driver.findElement(addressTextArea).sendKeys(newAddress);
	  driver.findElement(cityTextBox).clear();
	  driver.findElement(cityTextBox).sendKeys(newCity);
	  driver.findElement(By.xpath("//input[@name='sub']")).click();
	  

	  
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), newAddress);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), newCity);
	    }
   
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  public int randomEmail() {
	  Random rand = new Random();
	  int number = rand.nextInt(999999) + 1;
	  return number;
  }

}
