package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	//initializing the pageObject
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String ValidateTitle()
		{
			return driver.getTitle();
		}
		
		public void LoginMethod(String uname, String pswd) 
		{
			driver.findElement(By.name("email")).sendKeys(uname);
			driver.findElement(By.name("passwd")).sendKeys(pswd);
			driver.findElement(By.name("SubmitLogin")).click();
		}
		
		public String AfterrightloginValidate()
		{
			String actualtext = driver.findElement(By.linkText("Tapankumar Bhatt")).getText();
			System.out.println(actualtext);
			return actualtext;
			
		}
		
		public String AfterwrongloginValidate()
		{
			String actualerr = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
			System.out.println(actualerr);
			return actualerr;
		}
		
		

}
