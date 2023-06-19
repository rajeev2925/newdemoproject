package Generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility 
{
public void Maximizewindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void implicitWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void select(WebElement element,int ind)
{
	Select sel=new Select(element);
	sel.selectByIndex(ind);
}
public void select(WebElement element,String value)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}

public void select(String text,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
public static String getscreenshot(WebDriver driver)
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	String path="./Photos/failedtests"+Java_Utility.getdate()+".jpeg";
	File src=new File(path);
	try {
	FileHandler.copy(temp, src);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
}

}
