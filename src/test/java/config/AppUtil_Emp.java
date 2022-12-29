package config;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogoutPage;

public class AppUtil_Emp {
	public static WebDriver d;
	@BeforeTest
	public static void setup()throws Throwable
	{
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://orangehrm.qedgetech.com/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AdminLoginPage login = PageFactory.initElements(d, AdminLoginPage.class);
		login.verifylogin("Admin","Qedge123!@#");
		
	}
	@AfterTest
	public static void teardown ()
	{
			
		AdminLogoutPage logout= PageFactory.initElements(d,AdminLogoutPage.class);
		logout.verifyLogout();
	}
	
	
	
	
	
	
	
	
	
	
	//d.findElement(By.xpath("(//span[normalize-space()='Username'])[1]")).sendKeys("Admin");
	//d.findElement(By.xpath("(//span[normalize-space()='Password'])[1]")).sendKeys("");
	//d.findElement(By.xpath("(//input[@value='LOGIN'])[1]")).click();
}
