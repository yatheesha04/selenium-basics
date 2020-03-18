package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pom.ELearningLoginPOM;
import com.pom.ELearningLoginPOM01;
import com.screenshot.CaptureScreenShot;
import com.util.DriverFactory;
import com.util.DriverNames;
import com.waits.WaitTypes;

public class ELearningLoginTest03 {

	private WebDriver driver = null;
	private ELearningLoginPOM01 eLearningLoginPOM = null;
	private WaitTypes waitTypes = null;
	private CaptureScreenShot captureScreenShot= null;
	
	@Before
	public void setUp() throws Exception{
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningLoginPOM = new ELearningLoginPOM01(driver);
		waitTypes = new WaitTypes(driver);
		captureScreenShot = new CaptureScreenShot(driver);
	}
	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(3000);
		
	}
	
	@Test
	public void test() {
		
		eLearningLoginPOM.loadPage();
		captureScreenShot.takeScreenshot();
		eLearningLoginPOM.clickLoginBtn();
		eLearningLoginPOM.sendMobileNumber("1234");
		eLearningLoginPOM.sendPassword("qwerty");
		eLearningLoginPOM.clickSignInBtn();
		captureScreenShot.takeScreenshot();
		//assertEquals("Mr. Gordan", waitTypes.waitForElementToBeVisible(By.xpath("//*[@id=\\\"My_Books\\\"]/div[2]/h2/span"), 20).getText());
		assertEquals("Mr. Gordan", eLearningLoginPOM.getLoggedInNameWithWaitTypes());
		
	}
	
}
