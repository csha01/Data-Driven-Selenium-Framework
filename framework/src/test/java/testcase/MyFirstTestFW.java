package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXlsData;

public class MyFirstTestFW extends BaseTest{
	
	@Test(dataProviderClass=ReadXlsData.class,dataProvider="exceltestdata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("sign_in"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("login_btn"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("Sign_in"))).click();
		
	}
	
}
