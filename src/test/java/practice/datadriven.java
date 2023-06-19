package practice;


import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Excell_Utility;
import Generic.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class datadriven 
{
	
	
    @DataProvider
	public Object[][] data() throws Throwable
	{
		Excell_Utility exl = new Excell_Utility();
		Object[][] setofdata =exl.data_driven_testdata("register_data");
		
		return setofdata;
	}
	
	
@Test(dataProvider = "data")
public void register_data_test(String gender,String fname,String lname,String mailid,String psw) throws Throwable
{
	WebDriver driver=null;
	try {
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disabled-notifications");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(option);
	String URL=File_Utility.get_property_data("appurl");
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[.='Register']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//label[.='"+gender+"']")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("FirstName")).sendKeys(fname);
	Thread.sleep(1000);
	driver.findElement(By.id("LastName")).sendKeys(lname);
	Thread.sleep(1000);
	driver.findElement(By.id("Email")).sendKeys(mailid);
	Thread.sleep(1000);
	driver.findElement(By.id("Password")).sendKeys(psw);
	Thread.sleep(1000);
	driver.findElement(By.id("ConfirmPassword")).sendKeys(psw);
	Thread.sleep(1000);
	driver.findElement(By.id("register-button")).click();
	Thread.sleep(1000);
	String text=driver.findElement(By.xpath("//a[@class=\"ico-logout\"]")).getText();
	System.out.println(text);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[.='Log out']")).click();	
	}catch (Exception e)
	{
		try
		{
			String error=driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
			System.out.println(error);
		
		
		}
		catch (Exception ex)
		{
			System.out.println(ex);
			fail();
		}
	}
	
	finally {
		driver.quit();
	}
}
}
