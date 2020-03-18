package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ELearningLoginPOM {
	
	private WebDriver webdriver = null;
	String URL = "http://elearning.ohbreaks.com/";
	
	public ELearningLoginPOM(WebDriver driver) {
		this.webdriver = driver;
	}
	
	public void loadPage() {
		webdriver.get(URL);
	}
	
	public void closePage() {
		webdriver.quit();
	}
	
	public void clickLoginBtn() {
		String loginBtn = "login_main_btn";
		webdriver.findElement(By.id(loginBtn)).click();
	}
	
	
	public void sendMobileNumber(String mobileNo) {
		String mobileNumber = "//*[@id='log_in_form']/form/div[1]/div[2]/input";
		webdriver.findElement(By.xpath(mobileNumber)).clear();
		webdriver.findElement(By.xpath(mobileNumber)).sendKeys(mobileNo);
	}
	
	
	public void sendPassword(String passwordParam) {
		String password = "//*[@id=\"log_in_form\"]/form/div[2]/input";
		webdriver.findElement(By.xpath(password)).clear();
		webdriver.findElement(By.xpath(password)).sendKeys(passwordParam);
	}
	
	public void clickSignInBtn() {
		String signinBtn = "//*[@id=\"log_in_form\"]/form/div[4]/div[1]/button";
		webdriver.findElement(By.xpath(signinBtn)).click();
	}
	
	public String getLoginName() {
		String retString = "//*[@id=\"My_Books\"]/div[2]/h2/span";
		String logInName = webdriver.findElement(By.xpath(retString)).getText();
		return logInName;
	}
	
}