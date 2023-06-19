package practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		try {	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();}
		catch (Exception e) {}
		driver.findElement(By.xpath("//input[@title=\"Search for products, brands and more\"]")).sendKeys("i phone 12 128bg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
		String txt[]=text.split(" ");
		int expnum = Integer.parseInt(txt[5]);
		int totalcount=0;
		System.out.println(expnum);
		for(;;)
		{
			int count=driver.findElements(By.xpath("//div[@class='_4rR01T']")).size();
			totalcount=totalcount+count;
			try
			{
				WebElement nxtbtn = driver.findElement(By.xpath("//span[.='Next']"));
				//JavascriptExecutor js=(JavascriptExecutor) driver;
				//js.executeScript("arguments[0].scrollIntoView();",nxtbtn);
				Thread.sleep(1000);
				nxtbtn.click();
			}
			catch (Exception e) {
				break;
			}
		}
		
	Assert.assertEquals(totalcount, expnum);
	Reporter.log(" count is equal "+totalcount);
	driver.quit();
		
		
		
		
	

	}

}
