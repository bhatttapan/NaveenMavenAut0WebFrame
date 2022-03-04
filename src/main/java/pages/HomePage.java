package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class HomePage extends TestBase {
	
	//initializing the pageObject
			public HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public void ToOpenRegPage(String emailid) throws InterruptedException
			{
				driver.findElement(By.name("email_create")).sendKeys(emailid);
				driver.findElement(By.name("SubmitCreate")).click();
				Thread.sleep(2000);
			}
			
			public String VerifyRegMsg()
			{
				 return driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]")).getText();
				 
			}
			
			public void RegistrationMethod(String fname,String lname,String pword,String address,String city,String idstate,String idcountry) throws InterruptedException
			{
				driver.findElement(By.id("customer_firstname")).sendKeys(fname);
				 driver.findElement(By.id("customer_lastname")).sendKeys(lname);
				// driver.findElement(By.id("email")).sendKeys("tapan@gmail.com");
				 driver.findElement(By.id("passwd")).sendKeys(pword);
				// driver.findElement(By.id("firstname")).sendKeys("Tapan");
				// driver.findElement(By.id("lastname")).sendKeys("Bhatt");
				 driver.findElement(By.id("address1")).sendKeys(address);
				 driver.findElement(By.id("city")).sendKeys(city);
				 
				 
				 WebElement dropstate = driver.findElement(By.id("id_state"));
				 Select dropdownstate = new Select(dropstate);
				 dropdownstate.selectByVisibleText(idstate);
				 
				 driver.findElement(By.id("postcode")).sendKeys("12345");
				 
				 WebElement dropdowncountry = driver.findElement(By.id("id_country"));
				 Select dropcountry = new Select(dropdowncountry);
				 dropcountry.selectByVisibleText(idcountry);
				 
				 driver.findElement(By.id("phone_mobile")).sendKeys("6472370988");
				 driver.findElement(By.id("submitAccount")).click();
				 Thread.sleep(2000);
			}
			
			public String AfterRegMsg()
			{
				String ActualAfterRegMsg = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
				System.out.println(ActualAfterRegMsg);
				return ActualAfterRegMsg;
			}

}
