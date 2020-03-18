package com.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestMain {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/byathe/Desktop/Notes-Intern/chromedriver_win32/chromedriver.exe");
		
		String URL = "http://elearning.ohbreaks.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		System.out.println("Title of the page " + driver.getTitle());
		driver.close();
		
	}
}
