package SamplePackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class FirstMavenClass 
{
	@Test
	public void test1()
	{
		System.out.println("Testing maven class");
		
	}
	
	@Test
	public void test2() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDrivers/chromedriver.exe");
		
		ChromeDriver dr= new ChromeDriver();
		
		dr.manage().window().maximize();
		
		dr.get("https://www.google.com/");
		
		TakesScreenshot scrShot =((TakesScreenshot)dr);
        //Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(System.getProperty("user.dir")+"/Screenshots/homepage.jpg");
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);
		dr.findElement(By.name("q")).sendKeys("anand");
		
		 scrShot =((TakesScreenshot)dr);
        //Call getScreenshotAs method to create image file
		 SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		 DestFile=new File(System.getProperty("user.dir")+"/Screenshots/homepage2.jpg");
		//Copy file at destination
		FileHandler.copy(SrcFile, DestFile);
		
		
	}

}
