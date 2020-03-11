package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {
		
		
		click("addCustBtn_XPATH");
		//driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		type("firstName_XPATH", firstName);
		//driver.findElement(By.xpath(OR.getProperty("firstName"))).sendKeys(firstName);
		//type("firstName", firstName);
		//driver.findElement(By.xpath(OR.getProperty("lastName"))).sendKeys(lastName);
		type("lastName_XPATH", lastName);
		//driver.findElement(By.xpath(OR.getProperty("postCode"))).sendKeys(postCode);
		type("postCode_XPATH", postCode);
		//driver.findElement(By.xpath(OR.getProperty("submitBtn"))).click();
		click("submitBtn_XPATH");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alerttext));
		
		alert.accept();
		
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
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
