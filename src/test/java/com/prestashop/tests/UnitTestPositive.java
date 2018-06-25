package com.prestashop.tests;

import static com.prestashop.tests.UnitTest.driver;
import static com.prestashop.tests.Utilities.emailAuthenticationTest;
import static com.prestashop.tests.Utilities.signIn;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitTestPositive {
	
	@BeforeClass
	public static void setUpBeforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@BeforeMethod
	public static void setUpBeforeMethod(){
		signIn( "http://automationpractice.com", "//a[@class='login']");
	}
	
	@Test
	public void invalidEmailTest() throws InterruptedException {
		String expected="MY ACCOUNT";
		emailAuthenticationTest("archimedesphysics26@gmail.com","1234qwer"); 
		Thread.sleep(2000); 
	
		String actual=driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		Assert.assertEquals(actual, expected); 
	}
	@AfterClass
	public static void tearDown(){
		driver.close();
	}
	
	
}
