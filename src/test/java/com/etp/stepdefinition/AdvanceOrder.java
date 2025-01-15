package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.AdvanceOrderDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvanceOrder extends HelperClass{
	
	String CSV_Advanceordervalue = ".\\CSV\\advanceordervalue.csv";
	CSVReader reader = null;
	public static String advanceorderinvoicesave=null;
	AdvanceOrderDB db=new AdvanceOrderDB();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	@Given("the user is on the billing screen")
	public void user_is_on_billing_screen() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Advanceordervalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];		
			Thread.sleep(1000);	
			ThreeDotsCommon dots=new ThreeDotsCommon();
			dots.threedots();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'SELL ')]")).click();
			Thread.sleep(1000);
			WebElement salesperson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();
		//	Thread.sleep(1000);
		//	driver.findElement(By.xpath("//input[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
			}
		}catch (Exception e) {
		System.out.println("Exception occurs while selecting customer or salesperson"+e);
		}
		
	}

	@When("the user clicks on Order")
	public void user_click_on_order() {
	try {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Order')]")).click();	
	}
	catch (Exception e) {
	System.out.println("Exception Occurred while clicking on Order");
	}
	}

	@Then("the user selects an address for the advance order")
	public void user_select_address_for_advance_order() {
		try {
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//span[@class='small-sc-wd ng-star-inserted']")).click();
//			
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//div[@class='mat-radio-container'])[1]")).click();
//			
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//button[contains(text(),' OK ')])[2]")).click();
		}
		catch (Exception e) {
			System.out.println("Exception Occurred while selecting the address"+e);
		}
	}

	@And("the user searches for the product for the advance order")
	public void user_search_the_product_for_advance_order() {
		try {
			Thread.sleep(2000);
			reader = new CSVReader(new FileReader(CSV_Advanceordervalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productname = cell[i+1];	
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
		}
			}
		catch (Exception e) {
			System.out.println("Exception Occurred while searching the product"+e);
		}
	}

	@And("the user clicks on Checkout for the advance order")
	public void user_click_on_checkout_for_advance_order() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
			}
		catch (Exception e) {
			System.out.println("Exception Occurred while clicking on Checkout"+e);
		}
	}

	@And("the user clicks on Save for the advance order")
	public void user_click_on_save_for_advance_order() {
		try {
			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Cash')]")));
			cash.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		}
		catch (Exception e) {
			System.out.println("Exception Occurred while saving advance order"+e);
		}
	}

	@And("the user clicks on Submit for the advance order")
	public void the_user_click_on_submit_for_advance_order() {
		try {
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[contains(text(),' Order ')])[1]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();

			Thread.sleep(4000);
			advanceorderinvoicesave = driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
		}
		catch (Exception e) {
			System.out.println("Exception Occurred while submitting order invoice "+e);
		}
	}

	@Then("the user selects Order Processing")
	public void user_select_order_processing() {
		try {
			Thread.sleep(1000);
			ThreeDotsCommon dot=new ThreeDotsCommon();
			dot.threedots();
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'ORDER PROCESSING ')]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
			
			
//			Thread.sleep(4000);
//			
//			String orderinvoice=driver.findElement(By.xpath("(//div[@class='numClass'])[1]")).getText();
//			System.out.println(orderinvoice);
		}
		catch (Exception e) {
			System.out.println("Exception occurred while selecting Order Processing"+e);
		}
	}

	@And("the user selects the checkbox for the order")
	public void the_user_select_the_checkbox_for_the_order() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).sendKeys(advanceorderinvoicesave);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).clear();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).sendKeys(advanceorderinvoicesave);
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//div[@class='hbcheckbox'])[2]")).click();
		}
		catch (Exception e) {
			System.out.println("Exception Occurred while doing selecting Checkbox"+e);
		}
	}

	@And("the user clicks on Ship and Invoice")
	public void user_click_on_ship_and_invoice() {
		try {
	//		Thread.sleep(3000);
	//		driver.findElement(By.xpath("(//p[contains(text(),'Accept')])[1]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Ship & Invoice')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' YES ')])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' SAVE ')])[7]")).click();
		}
		catch (Exception e) {
		System.out.println("Exception Occurred while doing ship and invoice"+e);
		}
	}	
	
	@Then("the order is shipped and invoice successfully")
	public void the_order_is_shipped_and_invoice_successfully() {
	db.advanceOrderInvoiceSave();
	}

}
