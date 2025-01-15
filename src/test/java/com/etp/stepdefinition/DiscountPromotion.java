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

import com.etp.helper.DiscountPromoDbVerify;
import com.etp.helper.HelperClass;
import com.etp.helper.ShiftBeginDB;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiscountPromotion extends HelperClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	DiscountPromoDbVerify db=new DiscountPromoDbVerify();
	
	String CSV_Discountpromovalue = ".\\CSV\\discountpromovalue.csv";
	CSVReader reader = null;
	public static String discountpromonetamount=null;
	public static String discountpromoinvoice=null;

	@Given("the user is on the billing page")
	public void the_user_is_on_the_billing_page() {
	   System.out.println("user is on billing page");	
	}

	@When("the user selects a salesperson for the bill promotion")
	public void the_user_selects_a_salesperson_for_the_bill_promotion() {
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

	@When("the user selects a customer for the bill promotion")
	public void the_user_selects_a_customer_for_the_bill_promotion() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Discountpromovalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
		} }catch (Exception e) {
			System.out.println("Exception occurred while selecting the customer" + e);
		}
		
	}

	@When("the user scans a product for the bill promotion")
	public void the_user_scans_a_product_for_the_bill_promotion() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Discountpromovalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productsearch = cell[i+1];
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();

		}}catch (Exception e) {
			System.out.println("Exception occurred while scanning the product"+e);
		}
	}

	@When("the user clicks on checkout for the bill promotion")
	public void the_user_clicks_on_checkout_for_the_bill_promotion() {
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

	@When("the user selects the amount for the bill promotion")
	public void the_user_selects_the_amount_for_the_bill_promotion() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Discountpromovalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
			int i = 0;
			String referenceno = cell[i+2];
			WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
		    discountpromonetamount = amountElement.getText();
		    System.out.println("discountamount"+""+discountpromonetamount);
			Thread.sleep(6000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();
			//driver.findElement(By.xpath("//input[@placeholder='Enter Ref. No.']")).sendKeys(referenceno);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
			db.discountPromoNetAmount();
		} }catch (Exception e) {
			System.out.println("exception occurred while billing amount" + " " + e);
		}
	}

	@When("the user clicks on save for the bill promotion")
	public void the_user_clicks_on_save_for_the_bill_promotion() {
		try {		
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			Thread.sleep(4000);
			 discountpromoinvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
			  System.out.println("discountamount"+""+discountpromoinvoice);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();		
		} catch (Exception e) {
			System.out.println("Exception occurred while saving bill save" + e);
		}
	}

	@Then("the bill is saved successfully for discount promotion applied")
	public void the_bill_is_saved_successfully_for_discount_promotion_applied() throws Exception {
		
		db.discountPromoInvoiceSave();
	
	}
}
