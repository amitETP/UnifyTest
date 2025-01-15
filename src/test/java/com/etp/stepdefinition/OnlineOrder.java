package com.etp.stepdefinition;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etp.commonlinks.ThreeDotsCommon;
import com.etp.helper.HelperClass;
import com.etp.helper.OnlineOrderDB;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnlineOrder extends HelperClass {
	
	// private static final Logger logger = LogManager.getLogger(OnlineOrder.class);
	
	String CSV_onlineordervalue = ".\\CSV\\onlineordervalue.csv";
	CSVReader reader = null;
	public static String onlineorderinvoice=null;
	 OnlineOrderDB db=new OnlineOrderDB();

	@Given("user is on Order Processing")
	public void user_is_on_order_processing() {
		try {

			Thread.sleep(1000);
			ThreeDotsCommon dot = new ThreeDotsCommon();
			dot.threedots();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'ORDER PROCESSING ')]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[contains(text(),' Yes ')])[2]")).click();

		} catch (Exception e) {
			System.out.println("Exception Occurred while user is on Order Prcessing");
		}
	}

	@When("user click allocation")
	public void user_click_allocation() {
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@class='hbcheckbox'])[2]")).click();

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//p[contains(text(),'Allocation')]")).click();

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[3]/input")).click();

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[contains(text(),'Allocate Order')]")).click();

		} catch (Exception e) {
			System.out.println("Exception Occurred while selecting allocation" + e);
		}
	}

	@Then("user select Accept Order")
	public void user_select_accept_order() {
		try {
			
			Thread.sleep(1000);
			reader = new CSVReader(new FileReader(CSV_onlineordervalue));
			String[] cell = reader.readNext();

			while ((cell = reader.readNext()) != null) {
				int i = 0;
				String trackingno = cell[i];
				
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//p[contains(text(),'Accept')])[1]")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[contains(text(),' Mumbai -MBOS ')]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@class='enabledDiv ng-star-inserted']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted'])[2]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='mat-datepicker-4']/div/mat-month-view/table/tbody/tr[6]/td[2]/div")).click();
			
//			String f = "26 Oct 2024";
//			String[] dates = f.split(" ");
//			driver.findElement(By.xpath("(//div[@class='mat-calendar-controls']/button)[1]")).click();
//			List<WebElement> year = driver.findElements(By.xpath("//td"));
//			int k = 0;
//			while (true) {
//				if ((Integer.parseInt(dates[2])) < (Integer.parseInt(driver.findElement(By.xpath("(//td[@role='gridcell'])[1]")).getText()))) {
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("//div[@class='mat-calendar-controls']/button[2]")).click();
//					Thread.sleep(1000);
//					year = driver.findElements(By.xpath("//td"));
//				}
//				for (WebElement c : year) {
//					if (dates[2].equalsIgnoreCase(c.getText())) {
//						System.out.println(c.getText());
//						c.click();
//						k = 1;
//						break;
//					}
//				}
//				if (k == 1)
//					break;
//			}
//			Thread.sleep(1000);
//			List<WebElement> month = driver.findElements(By.xpath("//td"));
//			Thread.sleep(1000);
//			for (WebElement c : month) {
//				if (dates[1].equalsIgnoreCase(c.getText())) {
//					c.click();
//					break;
//				}
//			}
//
//			Thread.sleep(1000);
//			List<WebElement> caldate = driver.findElements(By.xpath("//td"));
//			Thread.sleep(1000);
//			for (WebElement c : caldate) {
//				System.out.println(c.getText());
//				if (dates[0].equalsIgnoreCase(c.getText())) {
//					c.click();
//					break;
//				}
//			}

			// time
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@class='ngx-material-timepicker-toggle'])[2]")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='clock-face__number clock-face__number--inner ng-star-inserted']/..//span[text()=' 22']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='timepicker-button']/span)[2]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@ng-reflect-name='trackingNumber']")).sendKeys(trackingno);

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),'SAVE')])[7]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Ok ')])[2]")).click();

		} }catch (Exception e) {
			System.out.println("Exception Occurred while Accepting the Order" + e);
		}

	}

	@Then("user click on Pack Order")
	public void user_click_on_pack_order() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Pack ')]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' YES ')])[1]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' SAVE ')])[2]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' Ok ')])[2]")).click();

		} catch (Exception e) {
			System.out.println("exception occured while Accepting the Order" + e);
		}
	}

	@Then("user click on Generate Shipping Label")
	public void user_click_on_generate_shipping_label() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Generate Shipping Label')]")).click();
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//p[contains(text(),'Ship & Invoice')]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),' YES ')])[2]")).click();

		} catch (Exception e) {
			System.out.println("Exception Occurred while generating shipping label "+e);
		}
	}

	@Then("user select Payment Option")
	public void user_select_payment_option() {
		try {
			Thread.sleep(1000);
			WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement cash = waits.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),' Cash')])[1]")));
			cash.click();
			// driver.findElement(By.xpath("//p[contains(text(),' Cash')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'ACCEPT')]")).click();
		} catch (Exception e) {
			System.out.println("Exception Occurred while selecting Payment Mode" + e);
		}
	}

	@Then("user click on submit")
	public void user_click_on_submit() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[contains(text(),' SUBMIT ')])[1]")).click();
			System.out.println("User Click on Submit");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='sell_anchor']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[contains(text(),'Reprint')]")).click();		
			Thread.sleep(4000);
			onlineorderinvoice=driver.findElement(By.xpath("(//tr[@class='table-row ng-star-inserted'])[1]/td[1]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='cross_x'])[1]")).click();	
		}catch (Exception e) {
			System.out.println("Exception Occurred while selecting submit button " + e);
	}
		}
}

