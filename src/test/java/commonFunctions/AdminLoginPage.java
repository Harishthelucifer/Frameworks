package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	//define repository
	@FindBy(xpath ="(//input[@type='text'])[2]")
	WebElement enterusername;
	@FindBy(xpath ="(//input[@type='password'])[1]")
	WebElement enterpassword;
	@FindBy(xpath ="(//input[@value='LOGIN'])[1]")
	WebElement loginbtn;
	//method for login
	public void verifylogin(String user,String pass)
	{
		enterusername.sendKeys(user);
		enterpassword.sendKeys(pass);
		loginbtn.click();
	}
	
	
	

}
