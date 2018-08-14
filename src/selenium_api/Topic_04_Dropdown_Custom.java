package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Topic_04_Dropdown_Custom {
	
	WebDriver driver;
	WebDriverWait wait;

  @Test
  public void fTC_01() throws Exception {
	  //jquery
	   
	   driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   selectCustomDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//li[@class='ui-menu-item']//div", "Slower");
	   Assert.assertTrue(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text' and text()='Slower']")).isDisplayed());
	   
	   selectCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//li[@class='ui-menu-item']//div", "19");
	   Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']")).isDisplayed());
	  
	   //Angular
	   driver.get("https://material.angular.io/components/select/examples");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   //driver.manage().window().maximize();
	   
	   selectCustomDropdown("//mat-select[@placeholder='Favorite food']", "//mat-option/span", "Pizza");
	   Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Pizza']")).isDisplayed());
  
	   selectCustomDropdown("//mat-select[@placeholder='State']", "//mat-option/span", "Wisconsin");
	   Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mat-select-value']//span[text()='Wisconsin']")).isDisplayed());
	   
	  // Kendo UI
	   driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	  
	   selectCustomDropdown("//span[@aria-owns='color_listbox']", "//ul[@id='color_listbox']/li", "Black");
	   Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-owns='color_listbox']//span[@class='k-input']/parent::span")).isDisplayed());
  
	   //vueejs
	   driver.get("https://mikerodham.github.io/vue-dropdowns/");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   
	   selectCustomDropdown("//div[@class='btn-group']/li", "//div[@class='btn-group']/ul/li/a", "First Option");
	   Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle' and contains(text(),'First Option')]")).isDisplayed());
	   
	   
	   //jquery edittable
	   //driver.get("http://indrimuska.github.io/jquery-editable-select/");
	   //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	   //driver.manage().window().maximize();
	   //selectCustomDropdown("//div[@id='default-place']/input", "//div[@id='basic-place']//ul[@class='es-list']/li", "Volkswagen");
	   //Assert.assertTrue(driver.findElement(By.xpath("//div[@id='default-place']/input")).isDisplayed());
	   
	   
	   //multiple select
	   //driver.get("http://wenzhixin.net.cn/p/multiple-select/docs/");
	   //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   //driver.manage().window().maximize();
	   //selectCustomDropdown("//p[@id='e1_t']/div", "//p[@id='e1_t']//li", "November");
	   //Assert.assertTrue(driver.findElement(By.xpath("//p[@id=\"e1_t\"]//label/span[text()=\"November\"]")).isDisplayed());
	   
	   //semanticUI
	   //driver.get("https://semantic-ui.com/modules/dropdown.html");
	   //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   //driver.manage().window().maximize();
	   //selectCustomDropdown("//div[@class='dropdown example']//div[text()='Select Country']","//div[@class='menu transition visible']//i","Turkey");
	   //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ui fluid search selection dropdown']/div[text()='Turkey']")).isDisplayed());
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver, 30);
  }

  public void selectCustomDropdown(String dropdown, String listItems, String valueItem) throws Exception {
	  Thread.sleep(3000);
	  WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
	  Thread.sleep(3000);
	  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
	  dropdownElement.click();
	  
	  //Lay tat ca item trong custom dropdown
	  List<WebElement> allItems = driver.findElements(By.xpath(listItems));
	  wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
	  Thread.sleep(3000);
	  for (WebElement item : allItems) {
		System.out.println(item.getText());
			if (item.getText().trim().equals(valueItem)) {
				//Scroll to element use javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

				Thread.sleep(3000);
				item.click();
				Thread.sleep(3000);
				break;
			}
		}

	}
  
  @AfterClass
  public void afterClass() {
  }

}
