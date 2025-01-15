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

import com.etp.helper.BillWithoutReferenceDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillWithoutReference extends HelperClass{
	BillWithoutReferenceDB db=new BillWithoutReferenceDB();
	
	String CSV_billwithoutreferencevalue = ".\\CSV\\billwithoutreferencevalue.csv";
	CSVReader reader = null;
	public static String withoutreferenceinvoice=null;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	@Given("the user is on the billing screen for Sales Return")
	public void the_user_is_on_the_billing_screen_for_Sales_Return() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_billwithoutreferencevalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];			
			Thread.sleep(1000);
			WebElement salesperson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();

		} }catch (Exception e) {
			System.out.println("exception occurred while selecting salesperson");
		}
	   
	}
	
	@When("the user clicks on Sales Return for without reference")
	public void the_user_click_on_Sales_Return_for_without_reference() {
		try {
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[@id='btm_box_bg_sr']")).click();
			}catch (Exception e) {
				System.out.println("Exception Occurred while clicking on sales return button"+e);			
			}
	}
	@Then("the user clicks on Without Reference")
	public void the_user_clicks_on_without_reference() {  
		  try {
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//span[contains(text(),'Without Reference')]")).click();
			    }catch (Exception e) {				
				}
	}

	@Then("the user searches for the product")
	public void user_search_the_product() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_billwithoutreferencevalue));
			String[] cell = reader.readNext();
			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productsearch = cell[i+1];		
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
	}}catch (Exception e) {
		System.out.println("Exception Occurred while selecting the product in bill without reference : "+e);
	}}

	@And("the user clicks on Checkout for without reference")
	public void user_clicks_on_checkout_for_without_reference() {
		try {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		}catch (Exception e) {
		System.out.println("Exception Occured while user click on checkout"+e);
		}
	}

	@And("the user clicks on Submit for without reference")
	public void user_clicks_on_submit_for_without_reference() {
	    try {
	    	Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
	    }catch (Exception e) {
		System.out.println("Exception occurred while clicking on submit button"+e);
		}
	    }
	

	@Then("the user clicks on save for without reference")
	public void user_clicks_on_save_for_withour_reference() {
		try {
		Thread.sleep(2000);
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
		 withoutreferenceinvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
		Thread.sleep(4000);
			driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
		}
	 catch (Exception e) {
		System.out.println("exception occur while saving invoice number" + " " + e);
	}
	}
	
	@Then("the user bill without reference for sales return is successful")
	public void the_user_clicks_on_save_for_without_reference() {
		db.billWithoutReferrenceInvoice();
		
	}
	

}
