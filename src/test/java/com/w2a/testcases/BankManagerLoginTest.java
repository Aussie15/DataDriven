package com.w2a.testcases;

import org.testng.annotations.Test;

import com.w2a.base.TestBase;



public class BankManagerLoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		log.debug("Inside Login Test");
		click("bmlBtn_XPATH");
		//driver.findElement(By.xpath(OR.getProperty("bmlBtnX"))).click();
		Thread.sleep(3000);
		
		log.debug("Login successfully executed");
	}
	
}
