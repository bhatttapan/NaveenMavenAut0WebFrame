package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import data.DataFile;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	
    HomePage home;
    DataFile df =new DataFile();
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException
	{
		initialization();
		home = new HomePage();
    }
	
	
	@Test(priority=1)
	public void InOrdertogetRegisterPage() throws InterruptedException
	{
		home.ToOpenRegPage("tapan.bhatt28@gmail.com");
	}
	
	@Test(priority=2)
	public void ValidateonRegPage() throws InterruptedException
	{
		home.ToOpenRegPage("tapan.bhatt28@gmail.com");
		String actualRegMsg = home.VerifyRegMsg();
		String expectedRegMsg = "YOUR PERSONAL INFORMATION";
		Assert.assertEquals(actualRegMsg, expectedRegMsg);
		
	}
	
	@Test(priority=3)
	public void VerifyAfterRegMsg() throws InterruptedException
	{
		home.ToOpenRegPage("tapan.bhatt28@gmail.com");
		home.RegistrationMethod(df.Firstname,df.Lastname,df.Password,df.Address,df.City,df.Idstate,df.Idcountry);
		Assert.assertEquals(home.AfterRegMsg(), "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		closeBrowser();
	}

}
