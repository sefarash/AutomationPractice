package com.prestashop.tests;

import static com.prestashop.tests.UnitTest.driver;
import static com.prestashop.tests.Utilities.emailAuthenticationTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Utilities {
	
	public static void signIn(String url, String xpath) {
		driver.get(url);
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public static void emailAuthenticationTest(String id, String pwd) {
		driver.findElement(By.id("email")).sendKeys(id);
		driver.findElement(By.id("passwd")).sendKeys(pwd);
		driver.findElement(By.name("SubmitLogin")).click();
	}
	
	public static void loginFunctionality(String id,String pwd,String expected){
		emailAuthenticationTest(id,pwd);
		String actual = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
		Assert.assertEquals(actual, expected);
	}

}
