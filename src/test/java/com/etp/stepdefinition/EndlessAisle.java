package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.EndlessAisleDB;
import com.etp.helper.HelperClass;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndlessAisle extends HelperClass {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	CSVReader reader = null;
	String CSV_Endlessaislevalue = ".\\CSV\\endlessaislevalue.csv";
	private String endlessAisleValue;
	public static String endlessaisle=null;

	@Given("the user is on the billing screen for Endless Aisle")
	public void the_user_is_on_billing_screen_for_EndlessAisle() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Endlessaislevalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String custname = cell[i];
				
			Thread.sleep(1000);

			WebElement salesperson = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salesPersonFirstDiv']")));
			salesperson.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[contains(text(),'Aniket Dengre')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='customerSearchDiv']")).sendKeys(custname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@class='highlight ng-star-inserted']")).click();

		} }catch (Exception e) {
			System.out.println("Exception occurs while selecting customer or salesperson");
		}

	}

	@When("the user clicks on Endless Aisle")
	public void the_user_click_on_endlessaisle() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'Order')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'Endless Aisle')]")).click();
		} catch (Exception e) {
			System.out.println("Exception Occurred while clicking on Order");
		}
	}

	@Then("the user selects an address for Endless Aisle")
	public void the_user_select_address_for_endlessaisle() {
		try {
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//span[@class='small-sc-wd ng-star-inserted']")).click();

//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//div[@class='mat-radio-container'])[1]")).click();
//
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//button[contains(text(),' OK ')])[2]")).click();
		} catch (Exception e) {
			System.out.println("Exception Occurred while selecting the address");
		}
	}

	@Then("the user searches for the product for Endless Aisle")
	public void the_user_search_the_product_for_endlessaisle() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Endlessaislevalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String productsearch = cell[i+1];
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='Product Search']")).sendKeys(productsearch);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[@id='productFirstLi']")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
		}} catch (Exception e) {
			System.out.println("Exception Occurred while searching the product");
		}

	}

	@And("the user clicks on Checkout for Endless Aisle")
	public void the_user_click_on_checkout_for_endlessaisle() {
		try {
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Endlessaislevalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String endlessaisledate = cell[i+3];
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECK AVAILABILITY ')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Nearby Stores')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@class='checkPos ng-untouched ng-pristine ng-valid'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='user-cre-chkbox-alignment'])[30]")).click();

			// select calender
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[3]")).click();
		
			String endlessaisledat = endlessaisledate;
			String[] dates = endlessaisledat.split(" ");
			driver.findElement(By.xpath("(//div[@class='mat-calendar-controls']/button)[1]")).click();
			List<WebElement> year = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			int k = 0;
			while (true) {
				if ((Integer.parseInt(dates[2])) < (Integer.parseInt(driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).getText()))) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//div[@class='mat-calendar-controls']/button[2]")).click();
					year = driver.findElements(By.xpath("//td"));
				}
				for (WebElement c : year) {
					if (dates[2].equalsIgnoreCase(c.getText())) {
					//	System.out.println(c.getText());
						c.click();
						k = 1;
						break;
					}
				}
				if (k == 1)
					break;
			}
			List<WebElement> month = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			for (WebElement c : month) {
				if (dates[1].equalsIgnoreCase(c.getText())) {
					c.click();
					break;
				}
			}

			List<WebElement> caldate = driver.findElements(By.xpath("//td"));
			Thread.sleep(1000);
			for (WebElement c : caldate) {
			//	System.out.println(c.getText());
				if (dates[0].equalsIgnoreCase(c.getText())) {
					c.click();
					break;
				}
			}

			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(text(),'ALLOCATE ORDER ')]")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),' CHECKOUT ')]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Proceed ')])[2]")).click();

		}} catch (Exception e) {
			System.out.println("Exception Occurred while clicking on Checkout" + e);
		}
	}

	@And("the user clicks on Save for Endless Aisle")
	public void the_user_click_on_save_for_endlessaisle() {
		try {
			Thread.sleep(6000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),' Cash')]")));
			cash.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		} catch (Exception e) {
			System.out.println("Exception Occurred while saving advance order");
		}
	}

	@And("the user clicks on Submit for Endless Aisle")
	public void the_user_click_on_submit_for_endlessaisle() {
		try {
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),' SAVE ')]")).click();
			

			Thread.sleep(10000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement reprint = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Reprint')]")));
			reprint.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-select[@placeholder='Bill']")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[contains(text(),' Order ')])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' APPLY')])[1]")).click();

			Thread.sleep(4000);
		   endlessaisle = driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();

			endlessAisleValue = endlessaisle;

		} catch (Exception e) {
			System.out.println("Exception Occurred while submitting order invoice " + e);
		}

	}

	@Then("the user selects Order Processing for Endless Aisle")
	public void user_select_order_processing_for_endlessaisle() {
		try {
			Thread.sleep(1000);
			ThreeDotsCommon dot = new ThreeDotsCommon();
			dot.threedots();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'ORDER PROCESSING ')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();
		} catch (Exception e) {
			System.out.println("Exception occur while clicking on order processing" + e);
		}
	}

	
	public void readVariable(String endlessaisle) {
		try {
			Thread.sleep(20000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).sendKeys(endlessaisle);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).clear();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@id='firstSearchField']")).sendKeys(endlessaisle);
		}catch (Exception e) {
			System.out.println("exception occured while reading variable"+e);
		}
	}
	
	
	
	@Then("the user selects the checkbox for the order for Endless Aisle")
	public void the_user_select_checkbox_for_endlessaisle() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_Endlessaislevalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String trackingno = cell[i+2];	
				readVariable(endlessAisleValue);
				
				Thread.sleep(6000);
				driver.findElement(By.xpath("(//div[@class='hbcheckbox'])[2]")).click();
				
//				Thread.sleep(10000);
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='hbcheckbox'])[2]")));
//				element.click();
				
			//	driver.findElement(By.xpath("(//div[@class='hbcheckbox'])[2]")).click();	
				Thread.sleep(3000);
				driver.findElement(By.xpath("//td[contains(text(),' Mumbai -MBOS ')]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//img[@class='enabledDiv ng-star-inserted']")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@ng-reflect-name='trackingNumber']")).sendKeys(trackingno);
			
				
		}}
		catch (Exception e) {
			System.out.println("Exception occurred while selecting Order Processing" + e);
		}
	}

	@Then("the user clicks on Ship and Invoice for Endless Aisle")
	public void user_click_on_ship_and_invoice_for_endlessaisle() {
		try {		
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),'SAVE')])[7]")).click();
			
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Ok ')])[2]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Pack ')]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' YES ')])[1]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' SAVE ')])[2]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Ok ')])[2]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Generate Shipping Label')]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Ship & Invoice')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' YES ')])[2]")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("(//button[contains(text(),' SAVE ')])[7]")).click();
		} catch (Exception e) {
			System.out.println("Exception Occurred while clicking on ship and invoice " + e);
		}
	}
	
	@Then("the order should be shipped and invoiced successfully")
	public void the_order_should_be_shipped_and_Invoiced_successfully() {
		EndlessAisleDB db = new EndlessAisleDB();
		db.endlessAisleInvoiceSave();
	}
}
