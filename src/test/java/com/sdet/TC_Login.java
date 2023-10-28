package com.sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Login {
	@Parameters("Browser")
	@Test
	public void login_Test(String browserName)
	{
		WebDriver driver=null;
		System.out.println("Parameter value is "+browserName);
		if(browserName.contains("Chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
    Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    driver.close();
	}
}
