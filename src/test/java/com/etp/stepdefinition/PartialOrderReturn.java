package com.etp.stepdefinition;

import java.io.FileReader;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.helper.HelperClass;
import com.etp.helper.PartialOrderDB;
import com.opencsv.CSVReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PartialOrderReturn extends HelperClass{
	
	@Given("User is on billing screen for partial order return")
	public void user_is_on_billing_screen_for_partial_order_return() {
	  
	}
	
	public static String billwithreference=null;

	@When("user clicks on Sales Return for partial order return")
	public void user_clicks_on_sales_return_for_partial_order_return() {
		try {
			Thread.sleep(6000);
		    driver.findElement(By.xpath("//div[@id='btm_box_bg_sr']")).click();
			}catch (Exception e) {
				System.out.println("Exception Occurred while clicking on sales return button"+e);
				
			}
	}

	@Then("user clicks on With Reference for partial order return")
	public void user_clicks_on_with_reference_for_partial_order_return() {
		  try {
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//span[contains(text(),'With Reference')]")).click();
			    }catch (Exception e) {
					System.out.println("Exception occured while clicking on bill with reference"+e);
				}
	}

	@And("user searches with Invoice Number for partial order return")
	public void user_searches_with_invoice_number_for_partial_order_return() {
		try{
			   
			   Thread.sleep(6000);
			   String CSV_Invoice = ".\\CSV Output\\Invoice.csv";
				CSVReader reader = null;
				reader = new CSVReader(new FileReader(CSV_Invoice));
				String[] cell = reader.readNext();

				while ((cell = reader.readNext()) != null) {
					int i = 0;
					String invoice = cell[i];		  
			 
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@placeholder='Search/Scan Invoice']")).sendKeys("CBSG0324C32110");
		   
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//td[@class='text-right cursor-pointer']")).click(); 
		   }}catch (Exception e) {
			System.out.println("exception occurred while searching invoice number");
		}
	}

	@And("user adds return quantity for order return")
	public void user_adds_return_quantity_for_order_return() throws Exception {
		 Thread.sleep(4000);
			driver.findElement(By.xpath("(//div[@class='display_inline2'])[1]")).click();
			
		//	 Thread.sleep(4000);
		//	driver.findElement(By.xpath("//div[@class='display_inline2']")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),' Return ')]")).click();
	}

	@And("user clicks on checkout for order return")
	public void user_clicks_on_checkout_for_order_return() throws Exception {
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
	}

	@And("user clicks on submit for order return")
	public void user_clicks_on_submit_for_order_return() {
		  try {
				Thread.sleep(4000);
				driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
			   }catch (Exception e) {
				System.out.println("Exception Occurred while submitting bill"+e);
			}
	}

	@Then("user clicks on save for order return")
	public void user_clicks_on_save_for_order_return() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();	
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[contains(text(),' Sales Return ')])[2]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();
		
		Thread.sleep(4000);
		String billwithreference=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
        
		System.out.println("Bill with Reference invoice is  "+" "+billwithreference);
	}

	@Then("bill is saved successfully for order return")
	public void bill_is_saved_successfully_for_order_return() throws Exception {
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[contains(text(),' Sales Return ')])[2]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();
		
		Thread.sleep(6000);
		billwithreference=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
        
	
	//	String a=billwithreference;
	//	System.out.println("Bill with Reference invoice is  "+" "+a);
		//add compare invoice number
		
		PartialOrderDB db=new PartialOrderDB();
		db.shibtdb();
	}
	
	

}
