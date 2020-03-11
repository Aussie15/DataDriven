package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class Media24Login extends TestBase{

	@Test(dataProvider="getData")
	public void media24(String emailAddress, String password, String headerText) throws InterruptedException, IOException {
		
		//WebElement element = driver.findElement(By.xpath("//span[@class='message_action']"));
		//wait.until(ExpectedConditions.textToBePresentInElementValue(element, "Lees jou gunsteling-tydskrifte en -koerante nou alles op een plek teen slegs R99 p.m."));
		//Assert.assertEquals("Lees jou gunsteling-tydskrifte en -koerante nou alles op een plek teen slegs R99 p.m.", headerText);
		//Assert.assertTrue(text.getText().contains(headerText));
//		
//		WebElement alert = wait.until(ExpectedConditions.textToBePresentInElementValue());
//		//type("search_XPATH", Soek);
//		WebElement HeaderText = driver.findElement(By.xpath("//span[@class='message_action']"));
//		
//		if(HeaderText.isDisplayed())
//		{
//			System.out.println("Subscription text is displayed");
//		}
//		else
//		{
//			System.out.println("Subcription text is not displayed");
//		}
//		System.out.println(actual);
//		
//		String expected = "Lees jou gunsteling-tydskrifte en -koerante nou alles op een plek teen slegs R99 p.m.";
//		Assert.assertEquals(actual, expected);
		click("meldAan_XPATH");
		
		//click("adBlocker_XPATH");
		//Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("adBlocker_XPATH"))),"Login not successful" );
		type("emailAdd_XPATH", emailAddress);
		Thread.sleep(3000);
		type("password_XPATH", password);
		Thread.sleep(5000);
		click("login_XPATH");
		
		//TestUtil.captureScreenshot();
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "netwerk24";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		
		for(int rowNum = 2; rowNum <= rows; rowNum++) {
			
			for(int colNum = 0; colNum < cols; colNum++) {
				
				data[rowNum -2] [colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
	}
}
