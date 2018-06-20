package com.prestashop.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrestaShopAutomationPractice {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" http://automationpractice.com");
	}
	
	@Test
	public void wrongCredentialsTest() {
		String expected ="Authentication failed.";
		
		
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).
		sendKeys("lastname.name@gmail.com");
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).
		sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitLogin")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(errorMessage, expected);
		
	}
	
	@Test
	public void invalidEmailTest() {
	String expected ="Invalid email address.";

	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
	driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).
	sendKeys("lastname.namegmail.com");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).clear();
	driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).
	sendKeys("123456789");
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	driver.findElement(By.id("SubmitLogin")).click();
	String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
	Assert.assertEquals(errorMessage, expected);
	}
	
	@Test
	public void blankEmailTest() {
		String expected ="An email address required.";

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).
		sendKeys("");
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).
		sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitLogin")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(errorMessage, expected);
		}
	
	@Test
	public void blankPasswordTest() {
		String expected ="Password is required.";

		
		driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).
		sendKeys("lastname.name@gmail.com");
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).
		sendKeys("");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitLogin")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(errorMessage, expected);
		}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	public class LoginPositiveScenarios{
		
		@Test
		public void loginTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			String expected = "Rashad Ismayilov";
			driver.get("http://automationpractice.com");
			driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
			driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).clear();
		    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]")).
			sendKeys("ismayilov.rashad@gmail.com");
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).clear();
			driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]")).
			sendKeys("Hazma2006");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("SubmitLogin")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String errorMessage = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
			Assert.assertEquals(errorMessage, expected);
			driver.close();
			
		}
	}

	

}
