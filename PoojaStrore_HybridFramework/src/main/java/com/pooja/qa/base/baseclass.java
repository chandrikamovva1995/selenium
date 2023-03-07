package com.pooja.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public baseclass()  {

	try {
		 prop = new Properties();
		FileInputStream fis=new FileInputStream("D:\\Testing Tools\\eclipse-workspace\\PoojaStrore_Hybrid\\src\\main\\java\\com\\pooja\\qa\\config\\config");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
e.printStackTrace();
	}
	}
	public static void initilization()
	{
		String browser=prop.getProperty("browsername");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
	{
		System.out.println("other browsername");
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("url");
	
	
	

}
}