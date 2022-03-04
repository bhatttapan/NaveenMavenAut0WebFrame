package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage login;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialization();
		login = new LoginPage();
    }
	
	
	@Test
	public void VerifyloginTitle()
	{
		String actualTitle = login.ValidateTitle();
		String expectedTitle = "Login - My Store";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void LoginWithRightunameandpswd()
	{
		login.LoginMethod("bhatt.tapan1@gmail.com", "Automationtapan@1");
		Assert.assertEquals(login.AfterrightloginValidate(), "Tapankumar Bhatt");
	}
	
	@Test
	public void Loginwithwrongunameandpswd()
	{
		login.LoginMethod("gwjan@gmail.com", "safsdfgg");
		Assert.assertEquals(login.AfterwrongloginValidate(), "There is 1 error");
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		closeBrowser();
	}
	
}
