package com.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.DriverFactory;
import com.util.DriverNames;

public class ELearningLoginTest {
	
	private String URL;
	private WebDriver webdriver =null;
	
	
	@Before
	public void setUp() throws Exception{
		URL = "http://elearning.ohbreaks.com/";
		webdriver = DriverFactory.getDriver(DriverNames.CHROME);
		
	}
	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(3000);
		webdriver.close();
	}
	
	@Test
	public void test() {
		
		webdriver.get(URL);
		String loginBtn = "login_main_btn";
		String mobileNumber = "//*[@id='log_in_form']/form/div[1]/div[2]/input";
		String password = "//*[@id=\"log_in_form\"]/form/div[2]/input";
		String signinBtn = "//*[@id=\"log_in_form\"]/form/div[4]/div[1]/button";
		
		webdriver.findElement(By.id(loginBtn)).click();
		
		webdriver.findElement(By.xpath(mobileNumber)).sendKeys("123456");
		webdriver.findElement(By.xpath(password)).sendKeys("qwerty");
		webdriver.findElement(By.xpath(signinBtn)).click();
		
		String retString = "//*[@id=\"My_Books\"]/div[2]/h2/span";
		String logInName = webdriver.findElement(By.xpath(retString)).getText();
		
		assertEquals("Mr. Gordan", logInName);
		
		
		
		
	}
	
}
