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

import com.etp.helper.BillWithWalkinDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillWithWalkin extends HelperClass{
	public static String netamountwalkin=null;
	public static String walkininvoice=null;
	String CSV_billwithwalkinvalue = ".\\CSV\\billwithwalkinvalue.csv";
	CSVReader reader = null;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
	BillWithWalkinDB db=new BillWithWalkinDB();
	
	@Given("the user is on the billing page for a walk-in customer")
	public void the_user_is_on_billing_page_for_walkin_customer() throws Exception {
		Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id='customerSearchDiv']")).click();
	   
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//ul[@class='ul_1']/li[2]")).click();
	}

	@When("the user selects a salesperson for the walk-in customer")
	public void the_user_selects_a_salesperson_for_walkin_customer() {
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

	@Then("the user scans a product for the walk-in customer")
	public void the_user_scans_a_product_for_walkin_customer() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_billwithwalkinvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productsearch = cell[i];
			// product search

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);

			// product name click
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
	//		Thread.sleep(1000);

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

	@And("the user clicks on Checkout for the walk-in customer")
	public void the_user_clicks_on_checkout_for_walkin_customer() {
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

	@And("the user selects the amount for the walk-in customer")
	public void the_user_select_the_amount_for_walkin_customer() {

		try {
			// Wait for the element to be visible and retrieve the text
		//	WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
		//	String netamount = amountElement.getText();
			WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableHead3']/table/tbody/tr/td[2]/div")));
			netamountwalkin = amountElement.getText();

			Thread.sleep(6000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();

			// driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
			db.walkinamount();
		} catch (Exception e) {
			System.out.println("exception occurred while billing amount" + " " + e);
		}
	}

	@And("the user clicks on Save for the walk-in customer")
	public void the_user_clicks_on_save_for_walkin_customer() {
		try {
			// save bill
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
			
			Thread.sleep(4000);
		    walkininvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
				
			}
		 catch (Exception e) {
			System.out.println("exception occur while saving invoice number" + " " + e);
		}
				
		}

	@Then("the bill is saved successfully for the walk-in customer")
	public void the_bill_is_saved_successfully_for_walkin_customer() throws Exception {  
		db.walkinInvoiceSave();
	}	
}