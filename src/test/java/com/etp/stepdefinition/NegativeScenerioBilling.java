package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.Modulemenu;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeScenerioBilling extends HelperClass {
	String CSV_Negativebilling = ".\\CSV\\negativebilling.csv";
	String CSV_Login = ".\\CSV\\Login.csv";
	String CSV_negativebillingResult = ".\\CSV_Result\\negativesceneriobillingresult.csv";
	CSVReader reader = null;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	@Given("the user is on the product search page")
	public void the_user_is_on_the_product_search_page() throws Exception {
//		 HelperClass.openPage();
//		 
//		 Thread.sleep(1000);
//			reader = new CSVReader(new FileReader(CSV_Login));
//			String[] cell = reader.readNext();
//
//			while ((cell = reader.readNext()) != null) {
//				int i = 0;
//				String txt_userName = cell[i];
//				String loc_userName = cell[i + 1];
//				String txt_userPassword = cell[i + 2];
//				String loc_userPassword = cell[i + 3];
//				String loc_loginButton = cell[i + 4];
//				Thread.sleep(1000);
//				driver.findElement(By.name(loc_userName)).sendKeys(txt_userName);
//
//				Thread.sleep(1000);
//				driver.findElement(By.id(loc_userPassword)).sendKeys(txt_userPassword);
//				
//				Thread.sleep(1000);
//				driver.findElement(By.id(loc_loginButton)).click();
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//				WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Sylphy Training1')]")));
//				element3.click();
//				
//		 
//				
//			///shift Begin
//				
//				Thread.sleep(1000);
//				ThreeDotsCommon lines = new ThreeDotsCommon();
//				lines.threedots();
//				
//				
//				Thread.sleep(6000);
//				Modulemenu pos = new Modulemenu();
//				pos.POS();
//				
//				Thread.sleep(6000);
//				driver.findElement(By.xpath("//p[contains(text(),' Sylphy -India')]")).click();
//				
//
//				Thread.sleep(1000);
//				String CSV_Shiftbeginvalue= ".\\CSV\\shiftbeginvalue.csv";
//				CSVReader reader = null;
//				reader = new CSVReader(new FileReader(CSV_Shiftbeginvalue));
//				String[] cells = reader.readNext();
//
//				while ((cells = reader.readNext()) != null) {
//					int j = 0;
//					String store_name = cells[j + 1];
//				
//
//					WebElement storesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-placeholder bg_imp ng-untouched ng-pristine ng-valid']")));
//					storesearch.sendKeys(store_name);
//
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("(//div[@class='card-box'])[1] ")).click();
//					
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("//div[@class='card-box card-box-active']")).click();
//					
//					Thread.sleep(1000);
//
//					// select shift begin
//					WebElement shiftbegin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Begin Shift  ')]")));
//					shiftbegin.click();
//					// click on yes button
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("//button[contains(text(),' Yes ')]")).click();
		 
//	}
//}
	}

	@And("no salesperson is selected")
	public void no_salesperson_is_selected() throws Exception {
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname = cell[i];
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
		}
	}

	@When("the user enters a product name")
	public void the_user_enters_a_product_name() throws Exception {
		Thread.sleep(6000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String productname = cell[i + 1];

			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productname);
			// Thread.sleep(1000);
			// driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
		}
	}

	@Then("the system should display an error message for salesperson not displayed")
	public void the_system_should_display_an_error_message_for_salesperson_not_displayed() throws Exception {
		
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
			
		
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String ExpectedResult1 = cell[i + 2];
			// String ExpectedResult="PLEASE SELECT PRIMARY SALES PERSON TO PROCEED PRODUCT
			// SEARCH";

			Thread.sleep(1000);
			String ActualResult = driver.findElement(By.xpath("//span[contains(text(),'PLEASE SELECT PRIMARY SALES PERSON TO PROCEED PRODUCT SEARCH')]")).getText();
			  String result = ExpectedResult1.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
			 writer.writeNext(new String[] { ActualResult, ExpectedResult1, result });
		}}
	}

	@Given("no customer is selected")
	public void no_customer_is_selected() throws Exception {
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
		Thread.sleep(1000);
		

		WebElement salesperson = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
		salesperson.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();
	}

	@When("the user enters a product name in the search bar")
	public void the_user_enters_a_product_name_in_the_search_bar() throws Exception {

		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String prosearch = cell[i + 3];

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(prosearch);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
		}
	}

	@Then("the system should display an error message for customer not selected")
	public void the_system_should_display_an_error_message_for_customer_not_selected() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String expectedresult2 = cell[i + 4];

			String ExpectedResult = expectedresult2;

			Thread.sleep(2000);
			String ActualResult = driver.findElement(By.xpath("//span[contains(text(),'PLEASE SELECT CUSTOMER TO PROCEED PRODUCT SEARCH')]")).getText();
			
			String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
	        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		}}
	}

	@When("the user enters a invalid product name")
	public void the_user_enters_a_invalid_product_name() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname2 = cell[i + 5];
			String productsearch2 = cell[i + 6];

			Thread.sleep(1000);

			WebElement salesperson = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch2);

		}
	}

	@Then("the system should display a message for product not found")
	public void the_system_should_display_a_message_for_product_not_found() throws Exception {

		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String message2 = cell[i + 7];
			String ExpectedResult = message2;
			String ActualResult = driver.findElement(By.xpath("//li[contains(text(),' Product Not Found ')]")).getText();
			System.out.println(ExpectedResult + " " + ActualResult);
			
			String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
	        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		}}
	}

	@When("the user enters a customer name in the search bar")
	public void the_user_enters_a_customer_name_in_the_search_bar() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname3 = cell[i + 8];

			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='customerSearchDiv']")).sendKeys(custname3);
		}
	}

	@Then("the system should display a message for customer not found")
	public void the_system_should_display_a_message_for_customer_not_found() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String message3 = cell[i + 9];
			Thread.sleep(4000);
			String ActualResult = driver.findElement(By.xpath("//p[contains(text(),' No Record Available ')]")).getText();
			String ExpectedResult = message3;
			String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
	        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		}}
	}

	@When("the user scan a product")
	public void the_user_scan_a_product() throws Exception {

		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname4 = cell[i + 10];
			String proname2 = cell[i + 11];

			Thread.sleep(1000);

			WebElement salesperson = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname4);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(proname2);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();
		}
	}

	@When("the user is on the checkout page")
	public void the_user_is_on_the_checkout_page() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();
	}

	@When("no payment mode is selected")
	public void no_payment_mode_is_selected() {

	}

	@When("the user clicks the checkout button")
	public void the_user_clicks_the_checkout_button() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
	}

	@Then("the system should display an error message for payment not selected")
	public void the_system_should_display_an_error_message_for_payment_not_selected() throws Exception {
		
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String message6 = cell[i + 18];
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		
		String ExpectedResult = message6;
		String ActualResult = driver.findElement(By.xpath("//span[contains(text(),'Partial Payment Is Not Allowed')]")).getText();
		String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		
	}}}

	@When("the user changes the sales price to zero")
	public void the_user_changes_the_sales_price_to_zero() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String revisedprice = cell[i + 12];

			Thread.sleep(6000);
			driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='revisedOfferPrice']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='revisedOfferPrice']")).sendKeys(revisedprice);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-select[@ng-reflect-placeholder='Select Reason']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),' UPDATE')]")).click();
		}
	}

	@Then("the system should display an error message for zero salesprice")
	public void the_system_should_display_an_error_message_for_zero_salesprice() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String message4 = cell[i + 13];

			String ExpectedResult = message4;

			String ActualResult = driver.findElement(By.xpath("//span[contains(text(),'Revised Sales Price Can Not Be Zero')]")).getText();

			String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
	        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		}}
	}

	@When("the user selects primary salesperson")
	public void the_user_selects_primary_salesperson() throws Exception {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname5 = cell[i + 14];

			Thread.sleep(1000);

			WebElement salesperson = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname5);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();
		}
	}

	@When("the user selects  secondary salesperson")
	public void the_user_selects_secondary_salesperson() throws Exception {
		Thread.sleep(1000);

		WebElement salesperson = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonSecondDiv']")));
		salesperson.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();
	}

	@Then("the system should display a message for same salesperson selected")
	public void the_system_should_display_a_message_for_same_salesperson_selected() throws Exception {
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_negativebillingResult,true))) {
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String message5 = cell[i + 15];
			Thread.sleep(1000);
			String ActualResult = driver.findElement(By.xpath(
					"//span[contains(text(),'Secondary Sales Person should not be same as Primary Sales Person')]"))
					.getText();
			String ExpectedResult = message5;
			System.out.println(ActualResult + " " + ExpectedResult);
			
			  String result = ExpectedResult.equalsIgnoreCase(ActualResult) ? "Passed" : "Failed";
		        writer.writeNext(new String[] { ActualResult, ExpectedResult, result });
		}}
	}

	@When("the user scans the product")
	public void the_user_scans_the_product() throws Exception {
		
		Thread.sleep(1000);
		reader = new CSVReader(new FileReader(CSV_Negativebilling));
		String[] cell = reader.readNext();

		while ((cell = reader.readNext()) != null) {
			int i = 0;
			String custname6 = cell[i + 16];
			String prodname7 = cell[i + 17];
			Thread.sleep(1000);

			WebElement salesperson = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname6);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(prodname7);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();

		}
	}

	@Then("the system should display an error message for HSN code not configured")
	public void the_system_should_display_an_error_message_for_hsn_code_not_configured() {

	}

	@Then("the system should display an error message for charge model not configured")
	public void the_system_should_display_an_error_message_for_charge_model_not_configured() {

	}

	@Given("the user edit the charges")
	public void the_user_edit_the_charges() {

	}

	@Then("the system should display an error message for charges")
	public void the_system_should_display_an_error_message_for_charges() {

	}

	@Then("the user should remain on the checkout page")
	public void the_user_should_remain_on_the_checkout_page() {

	}

}
