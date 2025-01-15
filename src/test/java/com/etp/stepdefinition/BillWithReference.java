package com.etp.stepdefinition;

import java.io.FileReader;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.BillWithReferenceDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillWithReference extends HelperClass{
	
	CSVReader reader = null;
	public static String billwithreferenceinvoice=null;
	
	@Given("User is on billing screen")
	public void user_is_on_billing_screen() throws Exception {		
		
	}

	@When("user click on Sales Return")
	public void user_click_on_sales_return() {
		try {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='btm_box_bg_sr']")).click();
		}catch (Exception e) {
			System.out.println("Exception Occurred while clicking on sales return button"+e);
			
		}
	}

	@Then("user clicks on With Reference")
	public void user_clicks_on_with_reference() {
	    try {
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'With Reference')]")).click();
	    }catch (Exception e) {
			System.out.println("Exception occured while clicking on bill with reference"+e);
		}
	}

	@And("user search with Invoice Number")
	public void user_search_with_invoice_number() {
	   try{
		   String CSV_productscaninvoice = ".\\CSV_Result\\productscanresult2.csv";
			CSVReader reader = null;
			reader = new CSVReader(new FileReader(CSV_productscaninvoice));
			 reader.readNext();
	         reader.readNext();
	         String[] cell = reader.readNext();
	         if (cell != null) {
	                int i = 0;
	                String invoiceproduct = cell[i];
	                System.out.println("Invoice product from third row: " + invoiceproduct);
	   Thread.sleep(6000);
	   driver.findElement(By.xpath("//input[@placeholder='Search/Scan Invoice']")).sendKeys(invoiceproduct);
	   
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("(//td[@class='text-right cursor-pointer'])[1]")).click(); 
	   }}catch (Exception e) {
		System.out.println("exception occurred while searching invoice number");
	}}
	

	@And("user add return quantity and click on return")
	public void user_add_return_quantity_and_click_on_return() {
		try {
	 
	  Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='display_inline2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),' Return ')]")).click();
		}catch (Exception e) {
		System.out.println("Exception occured while selecting return"+e);
		}
	}

	@And("user clicks on checkout")
	public void user_clicks_on_checkout() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Cash')]")));
			cash.click();

			// driver.findElement(By.xpath("//input[@placeholder=' Cash']")).sendKeys(referenceno);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
			
		 }catch (Exception e) {
			System.out.println("exception occur while clicking on checkout" + " " + e);
		}
	}

	@And("user clicks on submit")
	public void user_clicks_on_submit() {
	   try {
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
	   }catch (Exception e) {
		System.out.println("Exception Occurred while submitting bill"+e);
	}
	}

	@Then("user clicks on save")
	public void user_clicks_on_save() {
		try {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();	
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement sr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),' Sales Return ')])[2]")));
		sr.click();
		
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//span[contains(text(),' Sales Return ')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();
		
		Thread.sleep(4000);
		 billwithreferenceinvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
		
		}catch (Exception e) {
			System.out.println("Exception occurred while saving the bill"+e);
		}
	}
	
	@Then("bill is saved successfully")
	public void bill_is_saved_successfully() {
		BillWithReferenceDB billreference=new BillWithReferenceDB();
		billreference.BillWithReferenceInvoiceSave();
	}
}
