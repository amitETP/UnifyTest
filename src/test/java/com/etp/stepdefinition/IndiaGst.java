package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.etp.helper.IndiaGstDB;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndiaGst extends HelperClass{
	
	IndiaGstDB db=new IndiaGstDB();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	String CSV_Indiagstvalue = ".\\CSV\\indiagstvalue.csv";
	CSVReader reader = null;
	@Given("the user is on the product scan page for India gst")
	public void the_user_is_on_the_product_scan_page_for_india_gst() {
	System.out.println("user is on billing page");
		
	}

	@When("the user selects a salesperson for India gst")
	public void the_user_selects_a_salesperson_for_india_gst() {
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

	@Then("the user selects a customer for India gst")
	public void the_user_selects_a_customer_for_india_gst() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Indiagstvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];
				
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
		}} catch (Exception e) {
			System.out.println("Exception occurred while selecting the customer" + e);
		}
	}

	@And("the user scans a product for India gst")
	public void the_user_scans_a_product_for_india_gst() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Indiagstvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productsearch = cell[i+1];
			// product search

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);

			// product name click
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
			Thread.sleep(1000);
			
			
			Thread.sleep(4000);
			String charges=driver.findElement(By.xpath("(//span[@class='text-right ng-star-inserted']/div/span)[1]")).getText();
		
			String[] invoicesave = { charges };

			// Specify the CSV file path
			String CSV_Invoice = ".\\CSV Output\\indiagstcharges.csv";

			// Write to CSV
			try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_Invoice))) {
				writer.writeNext(new String[] { "charges" }); 
				writer.writeNext(invoicesave); 
				System.out.println("Data saved to " + CSV_Invoice);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
				
			}
		 catch (Exception e) {
			System.out.println("exception occur while saving chargesr" + " " + e);
		}
	
		}}catch (Exception e) {
			System.out.println("exception occur while scanning product" + " " + e);
		}
	}

	@Then("the user clicks on checkout for India gst")
	public void the_user_clicks_on_checkout_for_india_gst() {
		try {
			// click on checkout button
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
		} catch (Exception e) {
			System.out.println("exception occur while clicking on checkout" + " " + e);
		}
	}

	@And("the user select the amount for India gst")
	public void the_user_select_the_amount_for_india_gst() {
		try {
			
			WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
			String netamount = amountElement.getText();
			
		//	logger.info("NetAmount from UI =" + " " + netamount);

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

	@And("the user clicks on save for India gst")
	public void the_user_clicks_on_save_for_india_gst() {
		try {
			// save bill
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			
					db.shiftdb();		
		} catch (Exception e) {
			System.out.println("Exception occurred while saving bill save" + e);
		}
	}

	@Then("the bill is saved successfully for India gst")
	public void the_bill_is_saved_successfully_for_india_gst() {
		System.out.println("bill is saved successfully");
	}
}
