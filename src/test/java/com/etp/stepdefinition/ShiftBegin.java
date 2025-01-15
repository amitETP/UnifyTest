package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.Modulemenu;
import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.ShiftBeginDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShiftBegin extends HelperClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	String CSV_Shiftbeginvalue= ".\\CSV\\shiftbeginvalue.csv";
	String CSV_Shiftbeginresult2= ".\\CSV_Result\\shiftbeginresult2.csv";
	CSVReader reader = null;
	public static String amount= null;

	@Given("POS link is displayed in menu")
	public void pos_link_is_displayed_in_menu() throws Exception {
			ThreeDotsCommon lines = new ThreeDotsCommon();
			lines.threedots();
	

	}

	@And("user is on POS link from menu")
	public void user_is_on_pos_link_from_menu() {
		try {
			Thread.sleep(6000);
			Modulemenu pos = new Modulemenu();
			pos.POS();
		} catch (Exception e) {
			System.out.println("Exception occurred while selecting pos");
		}
	}

	@Then("user select company")
	public void user_select_company() {
		try {

			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Shiftbeginvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String select_company = cell[i];

				// select company
				Thread.sleep(6000);
				driver.findElement(By.xpath("//p[contains(text(),' Sylphy -India')]")).click();

			}

		} catch (Exception e) {
			System.out.println("exception occurs in selecting company" + " " + e);
		}
	}

	@When("user select store")
	public void user_select_store() {
		try {

			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Shiftbeginvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
			//	String select_store = cell[i + 1];
				String store_name = cell[i + 1];
			//	String click_store = cell[i + 3];

				WebElement storesearch = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-placeholder bg_imp ng-untouched ng-pristine ng-valid']")));
				storesearch.sendKeys(store_name);

				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='card-box'])[1] ")).click();
			}
		} catch (Exception e) {
			System.out.println("exception occurs while selecting store" + " " + e);
		}
	}

	@And("user select counter")
	public void user_select_counter() {
		try {
			Thread.sleep(1000);
//			reader = new CSVReader(new FileReader(CSV_Shiftbeginvalue));
//			String[] cell = reader.readNext();
//
//			while ((cell = reader.readNext()) != null) {
//				int i = 0;
//				String select_counter = cell[i + 2];

				// select counter

				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='card-box card-box-active']")).click();

			//}
		} catch (Exception e) {
			System.out.println("exception occurs while selecting counter" + " " + e);
		}
	}

	@Then("shiftbegin is done successfully")
	public void shiftbegin_is_done_successfully() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Shiftbeginvalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String expectedresult = cell[i + 2];
			
			
			//click on plus button for adding amount 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='inpWidth2 form-control'])[1]")));
			element.click();
			

			// Wait for the element to be visible and retrieve the text
			WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='currencySection']/div[3]/div/div/table/tbody/tr/td[2]")));

			 amount = amountElement.getText();
			

			// Prepare data for CSV
		//	String[] data = { amount };

//			// Specify the CSV file path
//			String CSV_Shiftbegin = ".\\CSV Output\\shiftbeginvaluesave.csv";
//
//			// Write to CSV
//			try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_Shiftbegin))) {
//				writer.writeNext(new String[] { "Amount" }); // Header
//				writer.writeNext(data); // Data row
//				System.out.println("Data saved to " + CSV_Shiftbegin);
			

			Thread.sleep(1000);

			// select shift begin
			WebElement shiftbegin = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Begin Shift  ')]")));
			shiftbegin.click();
			// click on yes button
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),' Yes ')]")).click();
			
//			Thread.sleep(1000);
//			try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_Shiftbeginresult2))) {
//			writer.writeNext(new String[] { "After doing shift begin,we compare the Expected Result with  the Actual Result from UI." });
//			writer.writeNext(new String[] { "Expected Result", "Actual Result from UI", "Result" });
//			String ResultText=driver.findElement(By.xpath("//span[contains(text(),' Sylphy Training1 ')]")).getText();
//			String ExpectedResult=expectedresult;
//			String result = ExpectedResult.equalsIgnoreCase(ResultText) ? "Passed" : "Failed";
//			 writer.writeNext(new String[] { ResultText, ExpectedResult, result });
//			}
			}} catch (Exception e) {
			System.out.println("exception occur while selecting shift" + " " + e);
		}
		ShiftBeginDB db = new ShiftBeginDB();
	    db.shiftdb();
	}}
	
