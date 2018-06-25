package com.prestashop.tests;

import static com.prestashop.tests.Utilities.*;
import static com.prestashop.tests.Utilities.signIn;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitTest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@BeforeMethod
	public static void setUpBeforeMethod() {
		signIn("http://automationpractice.com","//a[@class='login']");
		
	}
	
	@Test
	public void wrongcredentialTest() {
		loginFunctionality("asd231@gmail.com","123dfg","Authentication failed.");
		
		
	}
	
	@Test
	public static void invalidEmailTest() {
		loginFunctionality("asd231gmail.com","123dfg","Invalid email address.");
	}
	
	@Test
	public static void  blankEmailTest() {
		loginFunctionality("","asdasd","An email address required."); 
		}
	
	@Test
	public void blankPasswordTest() {
		loginFunctionality("abc212@gmail.com","","Password is required."); 
		}
	
	@AfterTest
	public static void tearDown() {
		driver.close();
	}
	

}
