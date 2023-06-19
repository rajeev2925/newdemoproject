package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launch 
{
@Test
public void add() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://mictests.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
	/*Robot rbt=new Robot();
	rbt.keyPress(KeyEvent.VK_TAB);
	rbt.keyRelease(KeyEvent.VK_TAB);
	rbt.keyPress(KeyEvent.VK_TAB);
	rbt.keyRelease(KeyEvent.VK_TAB);
	rbt.keyPress(KeyEvent.VK_ENTER);
	rbt.keyRelease(KeyEvent.VK_ENTER);*/
	
}
}
