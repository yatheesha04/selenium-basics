package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.waits.WaitTypes;

public class ELearningLoginPOM01 {
	
	
	private WebDriver webDriver;
	private String URL = "http://elearning.ohbreaks.com/";
	
	public ELearningLoginPOM01(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="login_main_btn")
	private WebElement loginBtnHomeScreen;
	
	@FindBy(xpath = "//*[@id='log_in_form']/form/div[1]/div[2]/input")
	private WebElement mobileNo;
	
	@FindBy(xpath = "//*[@id=\"log_in_form\"]/form/div[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"log_in_form\"]/form/div[4]/div[1]/button")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id=\"My_Books\"]/div[2]/h2/span")
	private WebElement loggedInUserName;
	
	public void loadPage() {
		webDriver.get(URL);
	}
	
	public void closePage() {
		webDriver.quit();
	}
	
	public void clickLoginBtn() {
		loginBtnHomeScreen.click();
	}
	
	
	public void sendMobileNumber(String mobileNo) {
		this.mobileNo.clear();
		this.mobileNo.sendKeys(mobileNo);
	}
	
	
	public void sendPassword(String passwordParam) {
		this.password.clear();
		this.password.sendKeys(passwordParam);
	}
	
	public void clickSignInBtn() {
		signInBtn.click();
	}
	
	public String getLoginName() {
		return loggedInUserName.getText();
	}
	
	public String getLoggedInNameWithWaitTypes() {
		WaitTypes waitTypes = new WaitTypes(this.webDriver);
		return waitTypes.waitForClickableReady(loggedInUserName, 20).getText();
	}
	
}
