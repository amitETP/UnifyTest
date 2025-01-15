package com.etp.stepdefinition;

import java.io.FileReader;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.BillWithChargesDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillWithCharges extends HelperClass{
	
	public static String headercharges=null;
	public static String netamount=null;
	public static String linecharges=null;
	public static String invoice=null;
	CSVReader reader = null;
	String CSV_BillWithcharges = ".\\CSV\\billwithcharges.csv";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	@Given("the user is on the billing page for billing with charges")
	public void the_user_is_on_the_billing_page_for_billing_with_charges() {
	   
	}

	@When("the user selects a salesperson for billing with charges")
	public void the_user_selects_a_salesperson_for_billing_with_charges() {
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

	@When("the user selects a customer for billing with charges")
	public void the_user_selects_a_customer_for_billing_with_charges() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_BillWithcharges));
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

	@When("the user scans a product for billing with charges")
	public void the_user_scans_a_product_for_billing_with_charges() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_BillWithcharges));
			String[] cell = reader.readNext();
			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productname = cell[i+1];
		
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
			Thread.sleep(1000);

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

	@When("the user clicks on checkout for billing with charges")
	public void the_user_clicks_on_checkout_for_billing_with_charges() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
		} catch (Exception e) {
			System.out.println("exception occur while clicking on checkout" + " " + e);
		}
	}

	@When("the user selects the amount for billing with charges")
	public void the_user_selects_the_amount_for_billing_with_charges() {
		try {
			Thread.sleep(10000);
			headercharges = driver.findElement(By.xpath("//div[@id='Checkout_right']/div[3]/table[1]/tbody/tr/td[2]/div")).getText();
			Thread.sleep(1000);
			WebElement netAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
			netamount =netAmount.getText();
		//	Thread.sleep(1000);
		//	linecharges=driver.findElement(By.xpath("//tbody[@id='tbody_detail']/tr[2]/td/div/span[1]/div/span[1]")).getText();
			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();

			// driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
			BillWithChargesDB db=new BillWithChargesDB();
			db.headerChargesSave();
		//	db.lineChargesSave();
			db.netAmount();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		} catch (Exception e) {
			System.out.println("exception occurred while billing amount" + " " + e);
		}
	}

	@When("the user clicks on save for billing with charges")
	public void the_user_clicks_on_save_for_billing_with_charges() {
		try {
			// save bill
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			
			Thread.sleep(4000);
			 invoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
			//	db.netAmount();		
				} catch (Exception e) {
			System.out.println("Exception occurred while saving bill save" + e);
		}
	}

	@Then("the billing process is completed successfully")
	public void the_billing_process_is_completed_successfully() throws Exception {
		BillWithChargesDB db=new BillWithChargesDB();	
		db.invoiceSave();
	}

}
