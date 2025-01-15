package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.etp.helper.ProductScanDbVerify;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductScan extends HelperClass {
	
	ProductScanDbVerify db=new ProductScanDbVerify();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 
	String CSV_ProductScanvalue = ".\\CSV\\productscanvalue.csv";
	CSVReader reader = null;
	public static String netamount=null;
	public static String productscaninvoice=null;
	
	@Given("the user is on the product scan page")
	public void the_user_is_on_the_product_scan_page() {
		System.out.println("user is on billing page");
	}

	@When("the user selects a salesperson")
	public void the_user_selects_a_salesperson() {
		try {
			Thread.sleep(1000);	
			WebElement salesperson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

		} catch (Exception e) {
			System.out.println("exception occurred while selecting salesperson");
		}
	}
	
	@And("the user selects a customer")
	public void the_user_selects_a_customer() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_ProductScanvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];
				
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(1000);
			WebElement custsearch=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='highlight ng-star-inserted']")));
			custsearch.click();
		}} catch (Exception e) {
			System.out.println("Exception occurred while selecting the customer" + e);
		}
	}

	@Then("the user scans a product")
	public void the_user_scans_a_product() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_ProductScanvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				//String productname1 = cell[i+1];
				String productname2=cell[i+2];
//				String productname3=cell[i+3];
//				String productname4=cell[i+4];
//				String productname5=cell[i+5];
		
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname2);
			Thread.sleep(1000);
			
			
			WebElement salesperson = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='productFirstLi']")));
			salesperson.click();
			
			//driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
			//Thread.sleep(1000);
			
			
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname2);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
//			Thread.sleep(1000);
//			
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname3);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
//			Thread.sleep(1000);
//			
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname4);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
//			Thread.sleep(1000);
//
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname5);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
//			Thread.sleep(1000);
			// verify whether promotion popup is coming or not
//			String expectedResult = "Promotion is getting applied for 10% on Price";	
//			Thread.sleep(1000);
//			String actualResult = driver.findElement(By.xpath("//span[contains(text(),' Promotion is getting applied for 10% on Price ')]")).getText();
//			
//			if (expectedResult.equals(actualResult))
//				System.out.println("Promotion applied");
//			else {
//				System.out.print("Promotion not applied");
//			}

		} }catch (Exception e) {
			System.out.println("exception occur while scanning product" + " " + e);
		}

	}

	@And("the user clicks on checkout")
	public void the_user_clicks_on_checkout() {

		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
		} catch (Exception e) {
			System.out.println("exception occur while clicking on checkout" + " " + e);
		}
	}

	@And("the user select the amount")
	public void the_user_select_the_amount() {

		try {
			WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
			 netamount = amountElement.getText();

			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();

			// driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		} catch (Exception e) {
			System.out.println("exception occurred while billing amount" + " " + e);
		}
	}

	@And("the user clicks on save")
	public void the_user_clicks_on_save() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			
			Thread.sleep(4000);
			 productscaninvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
				db.netAmount();		
				} catch (Exception e) {
			System.out.println("Exception occurred while saving bill save" + e);
		}}


	@Then("the bill is saved successfully")
	public void the_bill_is_saved_successfully() {
		try {
			
		ProductScanDbVerify db=new ProductScanDbVerify();
			db.productScanInvoiceSave();
		
	}catch (Exception e) {
	System.out.println("Exception occurred while saving bill"+e);
	}
	}
}
