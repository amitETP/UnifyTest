package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.BillCancelVerify;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import scala.collection.immutable.RedBlackTree.Helper;

public class BillCancellation extends HelperClass{
	
	 BillCancelVerify db=new BillCancelVerify();
	 String CSV_billcancellationvalue = ".\\CSV\\billcancellationvalue.csv";
	 CSVReader reader = null;
	 public static String billcancelinvoice=null;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	@Given("the user is on the billing screen for bill cancellation")
	public void the_user_is_on_the_billing_screen_for_bill_cancellation() {
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

	@When("the user clicks on Sales Return for bill cancellation")
	public void the_user_click_on_sales_return_for_bill_cancellation() {
		try {
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@id='btm_box_bg_sr']")).click();
			}catch (Exception e) {
				System.out.println("Exception Occurred while clicking on sales return button"+e);
				
			}
	}

	@Then("the user clicks on Bill Cancellation")
	public void the_user_clicks_on_bill_cancellation() {
	    try {
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//span[contains(text(),'Bill Cancellation')]")).click();
	    }catch (Exception e) {
			System.out.println("exception occurred while clicking on bill cancellation button");
		}
	}

	@And("the user searches for the invoice number for bill cancellation")
	public void the_user_search_the_invoice_no_for_bill_cancellation() {
		try {
			 String CSV_discountpromoinvoice = ".\\CSV_Result\\discountpromoresult2.csv";
				CSVReader reader = null;
				reader = new CSVReader(new FileReader(CSV_discountpromoinvoice));
				 reader.readNext();
		         reader.readNext();
		         String[] cell = reader.readNext();
		         if (cell != null) {
		                int i = 0;
		                String invoiceproduct = cell[i];
		                System.out.println("Invoice product from third row: " + invoiceproduct);
		   Thread.sleep(6000);
		   String invoice = invoiceproduct;	
		   Thread.sleep(10000);
		//String invoicenumber = DiscountPromotion.discountpromoinvoice;
		 Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@placeholder='Search/Scan Invoice']")).sendKeys(invoice);
	//	   driver.findElement(By.xpath("//input[@placeholder='Search/Scan Invoice']")).clear();
	//	   driver.findElement(By.xpath("//input[@placeholder='Search/Scan Invoice']")).sendKeys(invoicenumber);
		}}catch (Exception e) {
		System.out.println("Exception Occurred while searching the invoice number:" +e);
		}
	}

	@And("the user clicks on Checkout for bill cancellation")
	public void the_user_clicks_on_checkout_for_bill_cancellation() {
		try {
			Thread.sleep(1000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			 driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
			
		} catch (Exception e) {
			System.out.println("exception occur while clicking on checkout" + " " + e);
		}
	}

	@And("the user clicks on Submit for bill cancellation")
	public void the_user_clicks_on_Submit_for_bill_cancellation() throws Exception {
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
	}

	@Then("the user clicks on Save for bill cancellation")
	public void the_user_clicks_on_Save_for_bill_cancellation() {
		try {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement sr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),' Sales Return ')])[2]")));
			sr.click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();
			Thread.sleep(4000);
			 billcancelinvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
			}catch (Exception e) {
				System.out.println("Exception occurred while saving the bill"+e);
			}}
	
	
	@Then("the bill cancellation should be successful")
	public void the_bill_cancellation_should_be_successful() {
		db.billCancelInvoice();	
}
}
