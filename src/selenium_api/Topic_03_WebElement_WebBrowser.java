package selenium_api;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_03_WebElement_WebBrowser {
  

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC01_IsDisplayed() throws Exception {

		WebElement elementEmail = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement elementAge = driver.findElement(By.xpath("//input[@id='under_18']]"));
		WebElement elementEdu = driver.findElement(By.xpath("//textarea[@id='edu']"));
		
		Assert.assertTrue(isControlDisplayed(elementEmail));
		Assert.assertTrue(isControlDisplayed(elementAge));
		Assert.assertTrue(isControlDisplayed(elementEdu));
		
		if(isControlDisplayed(elementEmail)&&isControlDisplayed(elementEdu))
		  {
			elementEmail.sendKeys("Automation Testing");
			elementAge.click();
			elementEdu.sendKeys("Automation Testing");
		  }
		  Thread.sleep(5000);
	}

	public boolean isControlDisplayed(WebElement element){
		return element.isDisplayed();
	}
	
	public void isControlEnabled(WebElement element) {
		if(element.isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is disabled");
		}
	}
	public void isControlSelected(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}
	@Test
	public void TC02_IsEnabled() {
		
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement ageRadio = driver.findElement(By.xpath("//input[@id='under_18']"));
		WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
		WebElement JobRole01Select = driver.findElement(By.xpath("//select[@id='job1']"));
		WebElement Interests = driver.findElement(By.xpath("//input[@id='development']"));
		WebElement Slider01 = driver.findElement(By.xpath("//input[@id='slider-1']"));
		WebElement ButtonIsEnable = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement AgeRadioButton = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		WebElement JobRole02 = driver.findElement(By.xpath("//select[@id='job2']"));
		WebElement InterestsCheckBox = driver.findElement(By.xpath("//select[@id='job2']"));
		WebElement Slider02 = driver.findElement(By.xpath("//input[@id='slider-2']"));
		WebElement ButtonIsDisable = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		WebElement BiographyTextArea = driver.findElement(By.xpath("//textarea[@id='bio']"));
		 
		isControlEnabled(emailTextBox);
		isControlEnabled(ageRadio);
		isControlEnabled(educationTextArea);
		isControlEnabled(JobRole01Select);
		isControlEnabled(Interests);
		isControlEnabled(Slider01);
		isControlEnabled(ButtonIsEnable);
		isControlEnabled(Password);
		isControlEnabled(AgeRadioButton);
		isControlEnabled(JobRole02);
		isControlEnabled(InterestsCheckBox);
		isControlEnabled(Slider02);
		isControlEnabled(ButtonIsDisable);
		isControlEnabled(BiographyTextArea);
	}

	@Test
	public void TC03_IsSelected() {

		WebElement ageRadio = driver.findElement(By.xpath("//input[@id='under_18']"));
		WebElement Interests = driver.findElement(By.xpath("//input[@id='development']"));
		isControlSelected(ageRadio);
		isControlSelected(Interests);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
