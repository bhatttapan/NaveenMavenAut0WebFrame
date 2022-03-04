package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try {
		FileInputStream f= new FileInputStream("C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Selenium_Workspace\\NaveenMavenOtherWebsite"
				+ "\\src\\main\\java\\com\\auto\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);	
	    }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	    catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	
		public static void initialization() throws InterruptedException {
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\chromedriver_win32 (1)\\safaridriver.exe");
			driver = new SafariDriver();
		}	
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
	
	
}
