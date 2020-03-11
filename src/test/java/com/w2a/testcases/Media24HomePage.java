package com.w2a.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;

public class Media24HomePage extends TestBase{

	@Test(dataProvider="getData")
	public void homePage(String headerText) throws InterruptedException {
		
		
		Assert.assertEquals("Lees jou gunsteling-tydskrifte en -koerante nou alles op een plek teen slegs R99 p.m.", headerText);
		
		test.log(LogStatus.INFO, "Validated : " + headerText);
		
		click("weatherWidget_XPATH");
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("location_XPATH"))), "Weather widget location verified");
		
		click("closeWeather_XPATH");
		
		click("beeld_XPATH");
		
		click("beeldArticle_XPATH");
		
		driver.navigate().back();
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "homePage";
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
